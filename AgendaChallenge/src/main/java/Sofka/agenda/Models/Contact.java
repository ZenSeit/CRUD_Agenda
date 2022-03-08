/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sofka.agenda.Models;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Diego Fernando Becerra Zambrano
 */


@Entity
@Table(name = "contact")
/**
 * Clase que presenta al contacto con atributos Id, Name, Phone, Email, Birth
 */
public class Contact {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_cont")
    private Long Id;
    @Getter @Setter @Column(name = "name_cont")
    private String Name;
    @Getter @Setter @Column(name = "phone_cont")
    private String Phone;
    @Getter @Setter @Column(name = "email_cont")
    private String Email;
    @Getter @Setter @Column(name = "birth_cont")
    private Date Birth;
  
}
