package com.lawyer.crm.crm.service;

import com.lawyer.crm.crm.exceptions.ComplaintsNotExistsException;
import com.lawyer.crm.crm.model.Actions;
import com.lawyer.crm.crm.model.Actions;

import java.util.List;


public interface ActionsService {
    Actions getSingleActions(Long id) throws ComplaintsNotExistsException;

    List<Actions> getAllActions();

    Actions updateActions(Long id, Actions complaints);

    Actions replaceActions(Long id, Actions complaints);

    Actions addNewActions(Actions complaints);

    boolean deleteActions(Long id);
}