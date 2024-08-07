package com.lawyer.crm.crm.service;

import com.lawyer.crm.crm.exceptions.ComplaintsNotExistsException;
import com.lawyer.crm.crm.model.ClientUser;
import com.lawyer.crm.crm.model.Complaints;

import java.util.List;

public interface ClientUserService {
    ClientUser getSingleClient(Long id) throws ComplaintsNotExistsException;

    List<ClientUser> getAllClient();

    ClientUser updateClient(Long id, ClientUser complaints);

    ClientUser replaceClient(Long id, ClientUser complaints);

    ClientUser addNewClient(ClientUser complaints);

    boolean deleteClient(Long id);
}
