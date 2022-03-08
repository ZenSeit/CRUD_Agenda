/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Sofka.agenda.Service;

import Sofka.agenda.Models.Contact;
import java.util.List;

/**
 *
 * @author diego
 * Se presentan los metodos que se deben implementar para la conexion a la base de datos
 */
public interface IContact {
    
    public List<Contact> getContacts(); /*{
        String query = "FROM Contact";
        return entityManager.createQuery(query).getResultList(); //To change body of generated methods, choose Tools | Templates.
    }*/

    
    public void Delete(Long id); /*{
        Contact cont = entityManager.find(Contact.class, id);
        entityManager.remove(cont); //To change body of generated methods, choose Tools | Templates.
    }*/

    
    public Contact Save(Contact cont); /*{
        entityManager.merge(cont); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    public Contact Update(Long id, Contact cont);
    
}
