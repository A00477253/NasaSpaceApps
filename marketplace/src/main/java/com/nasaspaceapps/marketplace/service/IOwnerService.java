package com.nasaspaceapps.marketplace.service;

import com.nasaspaceapps.marketplace.entity.Owners;

import java.util.List;

public interface IOwnerService {
    Owners saveOwner(Owners owners);

    List<Owners> getAllOwners();

    Owners getOwnerByEmailId(String emaiId);

    void saveOwnerCredentials(Owners owners);

    List<Owners> getOwnerBySkillsMatched(List<String> skills);
}
