package com.nasaspaceapps.marketplace.service;

import com.nasaspaceapps.marketplace.entity.Collaborator;

public interface ICollaboratorService {
    Collaborator saveCollaborator(Collaborator collaborator);

    void saveCollboratorCredentials(Collaborator collaborator);

    Collaborator getCollaboratorByEmailId(String emailId);
}
