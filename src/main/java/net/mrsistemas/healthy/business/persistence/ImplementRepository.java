package net.mrsistemas.healthy.business.persistence;

import net.mrsistemas.healthy.business.persistence.entities.Country;
import net.mrsistemas.healthy.business.persistence.repository.CountryRepository;
import org.hibernate.SessionFactory;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public abstract class ImplementRepository implements CountryRepository {

     private SessionFactory factory;

     @Transactional(readOnly = true)
    public Set<Country> getCountriesByNameStartingWith(@NonNull String name){
        Set<Country> countries = null;
        System.out.println(name.toUpperCase());
        countries = (Set<Country>) getFactory().getCurrentSession().createQuery("from Country where upper(name) like '" + name +"'").list();
        return countries;
    }

    private SessionFactory getFactory() {
        return factory;
    }

    private void setFactory(SessionFactory factory) {
        this.factory = factory;
    }
}
