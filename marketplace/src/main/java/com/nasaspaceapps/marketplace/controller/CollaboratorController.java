package com.nasaspaceapps.marketplace.controller;


import com.nasaspaceapps.marketplace.entity.Collaborator;
import com.nasaspaceapps.marketplace.entity.CollaboratorMatch;
import com.nasaspaceapps.marketplace.entity.OwnerMatch;
import com.nasaspaceapps.marketplace.entity.Owners;
import com.nasaspaceapps.marketplace.mailsender.MailSenderService;
import com.nasaspaceapps.marketplace.service.ICollabMatchService;
import com.nasaspaceapps.marketplace.service.ICollaboratorService;
import com.nasaspaceapps.marketplace.service.IOwnerMatchService;
import com.nasaspaceapps.marketplace.service.IOwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/collaborator")
@Slf4j
public class CollaboratorController {

    @Autowired
    private ICollaboratorService collaboratorService;

    @Autowired
    private IOwnerService ownerService;

    @Autowired
    private ICollabMatchService collabMatchService;

    @Autowired
    private IOwnerMatchService ownerMatchService;

    @Autowired
    private MailSenderService mailSenderService;



    @PostMapping("/save")
    public ResponseEntity<Collaborator> saveCollaborator(@RequestBody Collaborator collaborator){
        Collaborator savedCollaborator=collaboratorService.getCollaboratorByEmailId(collaborator.getEmailId());
        if(savedCollaborator!=null){
            Collaborator errorCollaborator=new Collaborator();
            errorCollaborator.setErrorMessage("Email Id already exist");
            return new ResponseEntity<>(errorCollaborator, HttpStatus.BAD_REQUEST);
        }
        collaboratorService.saveCollboratorCredentials(collaborator);
        return new ResponseEntity<>(collaboratorService.saveCollaborator(collaborator),HttpStatus.OK);
    }

    @GetMapping("/fetchByEmailId")
    public ResponseEntity<Collaborator> getCollaboratorByEmailId(@RequestParam(name="emailId") String emailId){
        log.info("The email id is "+emailId);
        return new ResponseEntity<>(collaboratorService.getCollaboratorByEmailId(emailId),HttpStatus.OK);
    }

    @GetMapping("/TechStacks")
    public ResponseEntity<List<Owners>> getOwnerListByTechStacks(@RequestParam(name="skillSet") List<String> skillSet){
        log.info("The skill set is "+skillSet);

        List<Owners> ownerListMatched=ownerService.getOwnerBySkillsMatched(skillSet);
        if(ownerListMatched.isEmpty()){
            return new ResponseEntity<>(ownerListMatched,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ownerListMatched,HttpStatus.OK);
    }

    @PostMapping("/CollabMatch")
    public ResponseEntity<String> matchCollab(@RequestBody CollaboratorMatch collaboratorMatch){
        log.info("Inside the collab match ");

        OwnerMatch ownerMatch=ownerMatchService.
                getOwnerMatchByCollabEmailAndProject(collaboratorMatch.getCollaboratorEmail()
                        ,collaboratorMatch.getProjectName());
        log.info("The owner MAtch object for the collab is "+ownerMatch);

        collabMatchService.save(collaboratorMatch);
        if(null!=ownerMatch){
            Owners owners=ownerService.getOwnerByEmailId(ownerMatch.getOwnerEmail());
            Collaborator collaborator=collaboratorService.getCollaboratorByEmailId(ownerMatch.getCollabEmail());
            mailSenderService.sendSimpleEmailToCollaborator(owners,collaborator);
            mailSenderService.sendEmailToOwner(owners,collaborator);
            log.info("Inside the Owner match if clause");
        }
        return new ResponseEntity<>("Match saved successfully",HttpStatus.OK);
    }




}
