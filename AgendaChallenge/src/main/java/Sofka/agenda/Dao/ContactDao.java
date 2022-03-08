/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Sofka.agenda.Dao;

import Sofka.agenda.Models.Contact;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author diego
 * 
 * Interfaz que extiende los metodos de la base de datos
 */

public interface ContactDao extends CrudRepository<Contact, Long> {
    
    @Modifying
    @Query("update Contact set name_cont = :name where id_cont = :id")
    public void updateName(
            @Param(value = "id") Long id,
            @Param(value = "name") String name
    );
    
    @Modifying
    @Query("update Contact set phone_cont = :phone where id_cont = :id")
    public void updatePhone(
            @Param(value = "id") Long id,
            @Param(value = "phone") String phone
    );
    
    @Modifying
    @Query("update Contact set email_cont = :email where id_cont = :id")
    public void updateEmail(
            @Param(value = "id") Long id,
            @Param(value = "email") String email
    );
}
    
