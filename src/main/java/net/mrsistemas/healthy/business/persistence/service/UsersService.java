package net.mrsistemas.healthy.business.persistence.service;

import net.mrsistemas.healthy.business.persistence.entities.Users;
import net.mrsistemas.healthy.business.persistence.repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service(value = "dataService")
@Transactional
public class UsersService {

    @Autowired
    private UsersRepository dao;

    public UsersService() {
        super();
    }



    public Users create(final Users entity) {
        return dao.save(entity);
    }

    public Optional<Users> findOne(final long id) {
        Optional<Users> user = dao.findById(id);
        return dao.findById(id);
    }

    public List<Users> findAllUsers(){ return (List<Users>)  dao.findAll();}



}
