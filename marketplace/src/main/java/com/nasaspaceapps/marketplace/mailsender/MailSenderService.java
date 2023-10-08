package com.nasaspaceapps.marketplace.mailsender;

import com.nasaspaceapps.marketplace.entity.Collaborator;
import com.nasaspaceapps.marketplace.entity.Owners;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmailToCollaborator(Owners owners, Collaborator collaborator) {

        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("matchthefolks@gmail.com");
            helper.setTo(collaborator.getEmailId());
            helper.setSubject("Match found with the Project Owner");


            String htmlBody = "<html><body style=\"background-image: url('cid:image1'); background-size: cover;\">" +
                    "<table style=\"width:100%; height:100%;\"><tr><td style=\"text-align:center; vertical-align:middle;\">" +
                    "<div style=\"background-color:rgba(255, 255, 255, 0.8); padding: 20px;\">"+
                    "<h1>Owner Information</h1>" +
                    "<p>Email ID: " + owners.getEmailId() + "</p>" +
                    "<p>Project Name: " + owners.getProjectName() + "</p>" +
                    "<p>Reference Link: " + owners.getReferenceLink() + "</p>" +
                    "<p>Technical Stack: " + String.join(", ", owners.getTechStack()) + "</p>" +
                    "<p>Project Organization: " + owners.getProjectOrganization() + "</p>" +
                    "<p>Description: " + owners.getDescription() + "</p>" +
                    "<p>Expected Scope of Work: " + owners.getExpectedScopeOfWork() + "</p>" +
                    "<p>Expected Timeline: " + owners.getExpectedTimeline() + "</p>" +
                    "</div>"+
                    "</td></tr></table>" +
                    "</body></html>";


            helper.setText(htmlBody, true);
            FileSystemResource image = new FileSystemResource(new File("D:\\Nasa Space Apps\\marketplace\\src\\main\\resources\\matchfolks.jpg"));
            helper.addInline("image1", image);

            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendEmailToOwner(Owners owners, Collaborator collaborator) {

        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("matchthefolks@gmail.com");
            helper.setTo(owners.getEmailId());
            helper.setSubject("Match found with the Collaborator");


            String htmlBody = "<html><body style=\"background-image: url('cid:image1'); background-size: cover;\">" +
                    "<table style=\"width:100%; height:100%;\"><tr><td style=\"text-align:center; vertical-align:middle;\">" +
                    "<div style=\"background-color:rgba(255, 255, 255, 0.8); padding: 20px;\">"+
                    "<h1>Collaborator Information</h1>" +
                    "<p>Name: " + collaborator.getName() + "</p>" +
                    "<p>Email ID: " + collaborator.getEmailId() + "</p>" +
                    "<p>Organization: " + collaborator.getOrganisation() + "</p>" +
                    "<p>Professional Summary: " + collaborator.getProfessionalSummary() + "</p>" +
                    "<p>Skills: " + String.join(", ", collaborator.getSkills()) + "</p>" +
                    "<p>Types of Projects: " + collaborator.getTypesOfProject() + "</p>" +
                    "<p>Availability: " + collaborator.getAvailability() + "</p>" +
                    "</div>"+
                    "</td></tr></table>" +
                    "</body></html>";

            helper.setText(htmlBody, true); // Set the second argument to true for HTML content

            // Add the image as an inline attachment with content ID "image1"
            FileSystemResource image = new FileSystemResource(new File("D:\\Nasa Space Apps\\marketplace\\src\\main\\resources\\matchfolks.jpg"));
            helper.addInline("image1", image);

            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
