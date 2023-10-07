package com.nasaspaceapps.marketplace.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "owners")
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Owners {

    private String emailId;
    private String projectName;
    private String ownedBy;
    private String referenceLink;
    private List<String> techStack;
    private String expectedOutcome;
    @Transient
    private String errorMessage;
    @Transient
    private String password;



}
