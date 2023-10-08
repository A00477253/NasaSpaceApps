package com.nasaspaceapps.marketplace.service;

import com.nasaspaceapps.marketplace.entity.OwnerMatch;

public interface IOwnerMatchService {
    void saveOwnerMatch(OwnerMatch ownerMatch);

    OwnerMatch getOwnerMatchByCollabEmailAndProject(String collabEmail,String project);
}
