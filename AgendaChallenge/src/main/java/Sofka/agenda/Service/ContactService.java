/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sofka.agenda.Service;

import Sofka.agenda.Dao.ContactDao;
import Sofka.agenda.Models.Contact;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author diego
 * 
 * Implementacion de la interfaz IContact para establecer los servicios
 */

@Service
public class ContactService implements IContact {

    @Autowired
    private ContactDao condao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Contact> getContacts() {
        return (List<Contact>)condao.findAll();
    }
    
    @Transactional(readOnly = true)
    public Optional<Contact> getContact(Long id) {
        return condao.findById(id);
    }

    @Override
    @Transactional
    public void Delete(Long id) {
        condao.deleteById(id);
    }

    @Override
    @Transactional
    public Contact Save(Contact cont) {
        return condao.save(cont);
    }

    @Override
    @Transactional
    public Contact Update(Long id, Contact cont) {
        cont.setId(id);
        return condao.save(cont);
    }
    
    @Transactional
    public void UpdateName(Long id, Contact cont) {
        condao.updateName(id, cont.getName());
    }
    
    @Transactional
    public void UpdatePhone(Long id, Contact cont) {
        condao.updatePhone(id, cont.getPhone());
    }
    
    @Transactional
    public void UpdateEmail(Long id, Contact cont) {
        condao.updateEmail(id, cont.getEmail());
    }
    
}
