package com.nasaspaceapps.marketplace.service;

import com.nasaspaceapps.marketplace.entity.Credentials;
import com.nasaspaceapps.marketplace.entity.Owners;
import com.nasaspaceapps.marketplace.repository.CredentialsRepository;
import com.nasaspaceapps.marketplace.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OwnerService implements IOwnerService{

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Override
    public Owners saveOwner(Owners owners) {
        return ownerRepository.save(owners);
    }

    @Override
    public List<Owners> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Owners getOwnerByEmailId(String emailId) {

        return ownerRepository.findByEmailId(emailId);

    }

    @Override
    public void saveOwnerCredentials(Owners owners) {
        Credentials credentials=new Credentials();
        credentials.setPassword(owners.getPassword());
        credentials.setType("owner");
        credentials.setEmailId(owners.getEmailId());
        credentialsRepository.save(credentials);
    }

    @Override
    public List<Owners> getOwnerBySkillsMatched(List<String> skills) {
        return ownerRepository.findByTechStackInIgnoreCase(skills);
    }
}
