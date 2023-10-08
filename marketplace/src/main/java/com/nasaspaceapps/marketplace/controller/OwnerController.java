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

@RestController
@RequestMapping("/owner")
@Slf4j
public class OwnerController {

    @Autowired
    private IOwnerService ownerService;

    @Autowired
    private ICollaboratorService collaboratorService;

    @Autowired
    private IOwnerMatchService ownerMatchService;

    @Autowired
    private ICollabMatchService collabMatchService;

    @Autowired
    private MailSenderService mailSenderService;

    @PostMapping("/save")
    public ResponseEntity<Owners> saveOwner(@RequestBody Owners owners) throws Exception {
        log.info("The owner object is {}",owners);
        Owners savedOwner=ownerService.getOwnerByEmailId(owners.getEmailId());
        if(savedOwner!=null){
            Owners errorOwner=new Owners();
            errorOwner.setErrorMessage("Owner Email id is already available");
            return new ResponseEntity<>(errorOwner, HttpStatus.BAD_REQUEST);
        }
        ownerService.saveOwnerCredentials(owners);
        return new ResponseEntity<>(ownerService.saveOwner(owners), HttpStatus.OK);
    }

    @GetMapping("/getOwnerByEmailId/{emailId}")
    public ResponseEntity<Owners> getOwnerByEmailId(@PathVariable("emailId") String emailId){
        Owners savedOwner=ownerService.getOwnerByEmailId(emailId);
        return new ResponseEntity<>(savedOwner,HttpStatus.OK);
    }

    @GetMapping("/SkillSet")
    public ResponseEntity<List<Collaborator>> getCollaboratorBySkillSet(@RequestParam(name="techStack") List<String> techStack){
        log.info("The techstacks are "+techStack);
        List<Collaborator> collaboratorList=collaboratorService.getCollabsByTechStacks(techStack);
        if(collaboratorList.isEmpty()){
            return new ResponseEntity<>(collaboratorList,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(collaboratorList,HttpStatus.OK);
    }

    @PostMapping("/Match")
    public ResponseEntity<String> matchOwnerDetailsWithCollab(@RequestBody OwnerMatch ownerMatch){
        /* To Do
            Search in CollabMatch using the collab email
            Get all the matching with collab email for loop it and check if the collabMatch entity has anything specific
            to the project  and email id
         */
        CollaboratorMatch collaboratorMatch=collabMatchService.
                getOwnerByEmailAndProject(ownerMatch.getOwnerEmail(),ownerMatch.getProjectName());

        ownerMatchService.saveOwnerMatch(ownerMatch);
        if(null!=collaboratorMatch){
            //In this case collaborator has already matched with owner project
            //send email
            System.out.println("Colab email id is "+collaboratorMatch.getCollaboratorEmail());
            Collaborator collaborator=collaboratorService.
                    getCollaboratorByEmailId(collaboratorMatch.getCollaboratorEmail());
            System.out.println("Collab object is "+collaborator);
            Owners owners=ownerService.getOwnerByEmailId(collaboratorMatch.getOwnerEmail());
            mailSenderService.sendSimpleEmailToCollaborator(owners,collaborator);
            mailSenderService.sendEmailToOwner(owners,collaborator);

            log.info("Inside the collaborator if clause");
        }
        return new ResponseEntity<>("Matched Succesfully",HttpStatus.OK);

    }


}
