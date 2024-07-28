package com.segundaniels.segundaniels.controller;

import com.segundaniels.segundaniels.model.Contact;
import com.segundaniels.segundaniels.repository.ContactRepository;
import com.segundaniels.segundaniels.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping("/submit-form")
//    @CrossOrigin(origins = {"https://sdsc.42web.io","https://sdsc.42web.io/?i=1","http://127.0.0.1:5501", "http://localhost:8000"})
    public ResponseEntity<String> submitForm(@RequestBody Contact contact) {

        contactRepository.save(contact);

        // Send email to admin
        String adminEmailText = String.format("Name: %s\nEmail: %s\nSubject: %s\nMessage: %s",
                contact.getName(), contact.getEmail(), contact.getSubject(), contact.getMessage());


        emailService.sendSimpleMessage("sgsoftwareconsulting@gmail.com", "New Form Submission From SegunDaniels Website", adminEmailText);

        // Send confirmation email to sender
        String confirmationEmailText = String.format("Hello %s,\n\nThank you for reaching out!\n\nWe have received your message and will get back to you soon.\n\nBest regards,\nSegun Daniels Software Consulting Team", contact.getName());

        emailService.sendSimpleMessage(contact.getEmail(), "We Have Received Your Submission", confirmationEmailText);

        return ResponseEntity.ok("Thank You, We've Received Your Submission.");
    }
}