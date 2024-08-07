package com.lawyer.crm.crm.controller;

import com.lawyer.crm.crm.model.Category;
import com.lawyer.crm.crm.model.ClientUser;
import com.lawyer.crm.crm.model.Complaints;
import com.lawyer.crm.crm.repository.ActionRepository;
import com.lawyer.crm.crm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Provider;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/client")
public class ClientController {
    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    ResponseEntity<String> test(){
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    private ClientUserService clientUserService;
    @Autowired
    ClientController(@Qualifier("selfComplaintService") ClientUserService ClientUserService){
        this.clientUserService=ClientUserService;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
    ResponseEntity<List<ClientUser>> getAllComplaints(){
        List<ClientUser> clientUserList=clientUserService.getAllClient();
        return new ResponseEntity<List<ClientUser>>(clientUserList, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    ResponseEntity<ClientUser> postCategory(@RequestBody ClientUser user){
        ClientUser result=clientUserService.addNewClient(user);
        return new ResponseEntity<ClientUser>(result, HttpStatus.OK);
    }

}
