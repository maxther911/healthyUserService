package net.mrsistemas.iot.business.persistence.service;

import net.mrsistemas.iot.business.persistence.entities.DatosUsuario;
import net.mrsistemas.iot.business.persistence.entities.Users;
import net.mrsistemas.iot.business.persistence.repository.DataUserRepository;
import net.mrsistemas.iot.business.persistence.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class DataUsersService {

    @Autowired
    private UsersRepository dao;
    @Autowired
    private DataUserRepository daoData;

    public DataUsersService() {
        super();
    }

    public void create(final DatosUsuario entity) {
        daoData.save(entity);
    }

    public Optional<Users> findOne(final long id) {
        return dao.findById(id);
    }

    public List<Users> findAllUsers(){ return (List<Users>)  dao.findAll();}

    public List<DatosUsuario> findAll() {
        return (List<DatosUsuario>) daoData.findAll();
    }


}
