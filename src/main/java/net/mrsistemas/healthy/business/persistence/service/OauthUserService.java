package net.mrsistemas.healthy.business.persistence.service;


import net.mrsistemas.healthy.business.persistence.entities.OauthClientDetails;
import net.mrsistemas.healthy.business.persistence.entities.Role;
import net.mrsistemas.healthy.business.persistence.repository.OauthRepository;
import net.mrsistemas.healthy.business.persistence.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class OauthUserService {

    @Autowired
    private OauthRepository dao;

    @Autowired
    private RoleRepository daoRole;

    public Optional<OauthClientDetails> findOne(final String id) {
        return dao.findById(id);
    }

    public Role save(Role role){
        return daoRole.save(role);
    }

}
