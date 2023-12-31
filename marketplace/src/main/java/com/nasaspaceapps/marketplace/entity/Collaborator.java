package com.nasaspaceapps.marketplace.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="collaborator")
@Getter
@Setter
@ToString
public class Collaborator {
    private String name;
    private String emailId;
    @Transient
    private String password;
    private String organisation;
    private String professionalSummary;
    private List<String> skills;
    private String typesOfProject;
    private String availability;
    @Transient
    private String errorMessage;
}
