package com.nasaspaceapps.marketplace.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "owners")
@Getter
@Setter

public class Owners {
    @Id
    private String id;
    private String projectName;
    private String ownedBy;
    private String referenceLink;
    private List<String> techStack;
    private String expectedOutcome;



}
