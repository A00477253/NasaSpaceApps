package com.nasaspaceapps.marketplace.service;

import com.nasaspaceapps.marketplace.entity.Collaborator;
import com.nasaspaceapps.marketplace.entity.Credentials;
import com.nasaspaceapps.marketplace.repository.CollaboratorRepository;
import com.nasaspaceapps.marketplace.repository.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorService implements ICollaboratorService{

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Override
    public Collaborator saveCollaborator(Collaborator collaborator) {
        return collaboratorRepository.save(collaborator);
    }

    @Override
    public void saveCollboratorCredentials(Collaborator collaborator) {
        Credentials credentials=new Credentials();
        credentials.setPassword(collaborator.getPassword());
        credentials.setType("owner");
        credentials.setEmailId(collaborator.getEmailId());
        credentialsRepository.save(credentials);
    }

    @Override
    public Collaborator getCollaboratorByEmailId(String emailId) {
        return collaboratorRepository.findByEmailId(emailId);
    }

}
