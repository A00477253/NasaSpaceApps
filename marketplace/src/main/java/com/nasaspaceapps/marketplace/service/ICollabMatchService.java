package com.nasaspaceapps.marketplace.service;

import com.nasaspaceapps.marketplace.entity.CollaboratorMatch;

public interface ICollabMatchService {

    CollaboratorMatch getOwnerByEmailAndProject(String email,String project);

    void save(CollaboratorMatch collaboratorMatch);

}
