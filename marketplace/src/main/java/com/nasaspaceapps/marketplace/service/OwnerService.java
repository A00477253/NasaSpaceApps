package com.nasaspaceapps.marketplace.service;

import com.nasaspaceapps.marketplace.entity.Owners;
import com.nasaspaceapps.marketplace.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OwnerService implements IOwnerService{

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Owners saveOwner(Owners owners) {
        return ownerRepository.save(owners);
    }
}
