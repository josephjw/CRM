package com.lawyer.crm.crm.controller;

import com.lawyer.crm.crm.dto.ComplaintsDTO;
import com.lawyer.crm.crm.model.Actions;
import com.lawyer.crm.crm.model.Category;
import com.lawyer.crm.crm.model.Complaints;
import com.lawyer.crm.crm.repository.ActionRepository;
import com.lawyer.crm.crm.repository.CategoryRepository;
import com.lawyer.crm.crm.repository.ComplaintsRepository;
import com.lawyer.crm.crm.service.ActionsService;
import com.lawyer.crm.crm.service.CategoryService;
import com.lawyer.crm.crm.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/complaint")
public class ComplaintContoller {

    private ComplaintService complaintService;
    private CategoryService categoryService;

    private ActionsService actionsService;
    @Autowired
    private ComplaintsRepository complaintsRepository;
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ActionRepository actionsRepository;
    @Autowired
    ComplaintContoller(@Qualifier("selfComplaintService") ComplaintService complaintService,
                       @Qualifier("selfComplaintService") CategoryService categoryService,
                       @Qualifier("selfComplaintService") ActionsService actionsService){
        this.complaintService=complaintService;
        this.categoryService=categoryService;
        this.actionsService=actionsService;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
    ResponseEntity<List<Complaints>> getAllComplaints(){
        List<Complaints> complaintsList=complaintService.getAllItem();
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
        return new ResponseEntity<List<Complaints>>(complaintsList, HttpStatus.OK);

    }
        private void sendEmail(String to, String subject, String text) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            emailSender.send(message);
        }
    @RequestMapping(value = "/getAllAction", method = RequestMethod.GET, produces = "application/json")
    ResponseEntity<List<Actions>> getAllActions(){
        List<Actions> complaintsList=actionsService.getAllActions();
        return new ResponseEntity<List<Actions>>(complaintsList, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllCategory", method = RequestMethod.GET, produces = "application/json")
    ResponseEntity<List<Complaints>> getAllCategory(){
        List<Complaints> complaintsList=complaintService.getAllItem();
        return new ResponseEntity<List<Complaints>>(complaintsList, HttpStatus.OK);
    }

    @RequestMapping(value = "/createCategory", method = RequestMethod.POST, produces = "application/json")
    ResponseEntity<Category> postCategory(@RequestBody Category category){
        Category result=categoryService.addNewCategory(category);
        return new ResponseEntity<Category>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/createActions", method = RequestMethod.POST, produces = "application/json")
    ResponseEntity<Actions> postAction(@RequestBody Actions action){
        Actions result=actionsService.addNewActions(action);
        return new ResponseEntity<Actions>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    ResponseEntity<Complaints> postComplaints(@RequestBody ComplaintsDTO complaintsDTO){

        Category category = categoryRepository.findById(complaintsDTO.getCategoryId()).orElseThrow();
        Actions action = actionsRepository.findById(complaintsDTO.getActionId()).orElseThrow();

        Complaints complaints = new Complaints();
        complaints.setCase_name(complaintsDTO.getCase_name());
        complaints.setNotes(complaintsDTO.getNotes());
        complaints.setDescription(complaintsDTO.getDescription());
        complaints.setFileUrl(complaintsDTO.getFileUrl());
        complaints.setCategory(category);
        complaints.setAction(action);
        Complaints result=complaintService.addNewItem(complaints);
        return new ResponseEntity<Complaints>(result, HttpStatus.OK);
    }
}
