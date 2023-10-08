package com.nasaspaceapps.marketplace.service;

import com.nasaspaceapps.marketplace.entity.CollaboratorMatch;
import com.nasaspaceapps.marketplace.repository.CollaboratorMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollabMatchService implements ICollabMatchService{
    @Autowired
    private CollaboratorMatchRepository collaboratorMatchRepository;


    @Override
    public CollaboratorMatch getOwnerByEmailAndProject(String ownerEmail, String project) {
        return collaboratorMatchRepository.findByOwnerEmailAndProjectName(ownerEmail,project);
    }

    @Override
    public void save(CollaboratorMatch collaboratorMatch) {
        collaboratorMatchRepository.save(collaboratorMatch);
    }
}
