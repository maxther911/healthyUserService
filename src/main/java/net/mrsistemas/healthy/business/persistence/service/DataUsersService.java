package net.mrsistemas.healthy.business.persistence.service;

import net.mrsistemas.healthy.business.persistence.entities.DataUser;
import net.mrsistemas.healthy.business.persistence.entities.Users;
import net.mrsistemas.healthy.business.persistence.repository.DataUserRepository;
import net.mrsistemas.healthy.business.persistence.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service(value = "dataService")
@Transactional
public class DataUsersService {

    @Autowired
    private UsersRepository dao;

    @Autowired
    private DataUserRepository daoData;

    public DataUsersService() {
        super();
    }

    public DataUser create(final DataUser entity) {
        return daoData.save(entity);
    }

    public Users create(final Users entity) {
        return dao.save(entity);
    }

    public Optional<Users> findOne(final long id) {
        return dao.findById(id);
    }

    public List<Users> findAllUsers(){ return (List<Users>)  dao.findAll();}

    public List<DataUser> findAll() {
        return (List<DataUser>) daoData.findAll();
    }


}
