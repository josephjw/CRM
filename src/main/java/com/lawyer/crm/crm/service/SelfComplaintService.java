package com.lawyer.crm.crm.service;

import com.lawyer.crm.crm.exceptions.ComplaintsNotExistsException;
import com.lawyer.crm.crm.model.Actions;
import com.lawyer.crm.crm.model.Category;
import com.lawyer.crm.crm.model.ClientUser;
import com.lawyer.crm.crm.model.Complaints;
import com.lawyer.crm.crm.repository.ActionRepository;
import com.lawyer.crm.crm.repository.CategoryRepository;
import com.lawyer.crm.crm.repository.ClientsUserRepository;
import com.lawyer.crm.crm.repository.ComplaintsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service("selfComplaintService")
public class SelfComplaintService implements ComplaintService,CategoryService,ActionsService,ClientUserService {
    private ComplaintsRepository complaintsRepository;
    private CategoryRepository categoryRepository;
    private ActionRepository actionRepository;
    private ClientsUserRepository clientUserService;
    @Autowired
    SelfComplaintService(ComplaintsRepository complaintsRepository,
                         CategoryRepository categoryRepository,
                         ActionRepository actionRepository,
                         ClientsUserRepository clientUserService){
        this.complaintsRepository=complaintsRepository;
        this.categoryRepository=categoryRepository;
        this.actionRepository=actionRepository;
        this.clientUserService= clientUserService;
    }

    @Override
    public Complaints getSingleItem(Long id) throws ComplaintsNotExistsException {

        return null;
    }

    @Override
    public List<Complaints> getAllItem() {
        return complaintsRepository.findAll();
    }

    @Override
    public Complaints updateItem(Long id, Complaints complaints) {
        return null;
    }

    @Override
    public Complaints replaceItem(Long id, Complaints complaints) {
        return null;
    }

    @Override
    public Complaints addNewItem(Complaints complaints) {

        return complaintsRepository.save(complaints);
    }

    @Override
    public boolean deleteItem(Long id) {
        return false;
    }

    @Override
    public Category getSingleCategory(Long id) throws ComplaintsNotExistsException {
        return null;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Long id, Category complaints) {
        return null;
    }

    @Override
    public Category replaceCategory(Long id, Category complaints) {
        return null;
    }

    @Override
    public Category addNewCategory(Category complaints) {
        return categoryRepository.save(complaints);
    }

    @Override
    public boolean deleteCategory(Long id) {
        return false;
    }

    @Override
    public Actions getSingleActions(Long id) throws ComplaintsNotExistsException {
        return null;
    }

    @Override
    public List<Actions> getAllActions() {
        return null;
    }

    @Override
    public Actions updateActions(Long id, Actions complaints) {
        return null;
    }

    @Override
    public Actions replaceActions(Long id, Actions complaints) {
        return null;
    }

    @Override
    public Actions addNewActions(Actions actions) {
        return actionRepository.save(actions);
    }

    @Override
    public boolean deleteActions(Long id) {
        return false;
    }

    @Override
    public ClientUser getSingleClient(Long id) throws ComplaintsNotExistsException {
        return null;
    }

    @Override
    public List<ClientUser> getAllClient() {
        return clientUserService.findAll();
    }

    @Override
    public ClientUser updateClient(Long id, ClientUser complaints) {
        return null;
    }

    @Override
    public ClientUser replaceClient(Long id, ClientUser complaints) {
        return null;
    }

    @Override
    public ClientUser addNewClient(ClientUser clientUser) {
        return clientUserService.save(clientUser);
    }

    @Override
    public boolean deleteClient(Long id) {
        return false;
    }
}
