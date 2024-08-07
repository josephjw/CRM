package com.lawyer.crm.crm.service;

import com.lawyer.crm.crm.model.Complaints;
import com.lawyer.crm.crm.repository.ComplaintsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.logging.Logger;

@Service
public class ComplaintEmailService {
    private static final Logger LOGGER = Logger.getLogger(ComplaintEmailService.class.getName());

    @Autowired
    private ComplaintsRepository complaintsRepository;

    @Autowired
    private JavaMailSender emailSender;

//    @Scheduled(cron = "0 0 */2 * * *")
    @Scheduled(cron = "30 * * * * *")
    public void checkAndSendComplaints() {
        LOGGER.info("Checking for complaints where action is not 'closed'...");

        List<Complaints> complaintsList = complaintsRepository.findByAction_ActionNameNot("closed");

        if (!complaintsList.isEmpty()) {
            StringBuilder emailContent = new StringBuilder();
            emailContent.append("Complaints Details:\n\n");

            for (Complaints complaint : complaintsList) {
                emailContent.append("Case Name: ").append(complaint.getCase_name()).append("\n")
                        .append("Description: ").append(complaint.getDescription()).append("\n")
                        .append("Notes: ").append(complaint.getNotes()).append("\n")
                        .append("File URL: ").append(complaint.getFileUrl()).append("\n")
                        .append("User: ").append(complaint.getUserId().getCustomer_name()).append("\n")
                        .append("Category: ").append(complaint.getCategory().getCat_name()).append("\n")
                        .append("Action: ").append(complaint.getAction().getActionName()).append("\n\n");
            }

            sendEmail("infotostalin@gmail.com", "Pending Complaints Report", emailContent.toString());
        }
    }

    private void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}