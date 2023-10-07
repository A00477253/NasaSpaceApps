package com.nasaspaceapps.marketplace.service;

import com.nasaspaceapps.marketplace.entity.Collaborator;
import com.nasaspaceapps.marketplace.entity.Credentials;
import com.nasaspaceapps.marketplace.entity.Owners;
import com.nasaspaceapps.marketplace.repository.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialService implements ICredentialService{

    @Autowired
    private CredentialsRepository credentialsRepository;
    @Override
    public Credentials getCredentialsByEmailId( String emailId) {
        return credentialsRepository.findByEmailId(emailId);
    }

}
