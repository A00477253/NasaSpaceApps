package com.nasaspaceapps.marketplace.controller;


import com.nasaspaceapps.marketplace.entity.Collaborator;
import com.nasaspaceapps.marketplace.service.ICollaboratorService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/collaborator")
@Slf4j
public class CollaboratorController {

    @Autowired
    private ICollaboratorService collaboratorService;

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




}
