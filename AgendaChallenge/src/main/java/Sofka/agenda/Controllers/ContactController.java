/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sofka.agenda.Controllers;

import Sofka.agenda.Models.Contact;
import Sofka.agenda.Service.ContactService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diego
 */

@CrossOrigin(value="*")
@Slf4j
@RestController
/**
 * Clase controlador que presenta las rutas para acceder a los diferentes metodos
 */
public class ContactController {
    
    @Autowired
    private ContactService conser;
    
    @RequestMapping(value = "contacts", method = RequestMethod.GET)
    public List<Contact> getContacts(){        
        return conser.getContacts();
    }
    
    @RequestMapping(value = "contact/{id}", method = RequestMethod.GET)
    public Optional<Contact> harderase(@PathVariable("id") Long id){   
        return conser.getContact(id);   
    }
    
    @RequestMapping(value = "createcontact", method = RequestMethod.POST)
    public ResponseEntity<Contact> create(@RequestBody Contact cont){   
        conser.Save(cont);
        return new ResponseEntity<>(cont, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "deletecontact/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Contact> harderase(Contact cont, @PathVariable("id") Long id){   
        conser.Delete(id);
        return new ResponseEntity<>(cont, HttpStatus.OK);
    }
    
    @RequestMapping(value = "upcontact/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Contact> upcontact(@RequestBody Contact cont, @PathVariable("id") Long id){   
        conser.Update(id, cont);
        return new ResponseEntity<>(cont, HttpStatus.OK);
    }
    
    @RequestMapping(value = "upcontact/name/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Contact> upcontactName(Contact cont, @PathVariable("id") Long id){   
        conser.UpdateName(id, cont);
        return new ResponseEntity<>(cont, HttpStatus.OK);
    }
    
    @RequestMapping(value = "upcontact/phone/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Contact> upcontactPhone(Contact cont, @PathVariable("id") Long id){   
        conser.UpdatePhone(id, cont);
        return new ResponseEntity<>(cont, HttpStatus.OK);
    }
    
    @RequestMapping(value = "upcontact/email/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Contact> upcontactEmail(Contact cont, @PathVariable("id") Long id){   
        conser.UpdateEmail(id, cont);
        return new ResponseEntity<>(cont, HttpStatus.OK);
    }
    
}
