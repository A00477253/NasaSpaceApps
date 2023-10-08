package com.nasaspaceapps.marketplace.service;

import com.nasaspaceapps.marketplace.entity.OwnerMatch;
import com.nasaspaceapps.marketplace.repository.OwnerMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerMatchService implements IOwnerMatchService{
    @Autowired
    private OwnerMatchRepository ownerMatchRepository;
    @Override
    public void saveOwnerMatch(OwnerMatch ownerMatch) {
        ownerMatchRepository.save(ownerMatch);
    }

    @Override
    public OwnerMatch getOwnerMatchByCollabEmailAndProject(String collabEmail, String project) {
        return ownerMatchRepository.findByCollabEmailAndProjectName(collabEmail,project);
    }
}
