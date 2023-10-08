package com.nasaspaceapps.marketplace.service;

import com.nasaspaceapps.marketplace.entity.Collaborator;

import java.util.List;

public interface ICollaboratorService {
    Collaborator saveCollaborator(Collaborator collaborator);

    void saveCollboratorCredentials(Collaborator collaborator);

    Collaborator getCollaboratorByEmailId(String emailId);

    List<Collaborator> getCollabsByTechStacks(List<String> techSkills);
}
