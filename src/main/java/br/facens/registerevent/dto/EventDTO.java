package br.facens.registerevent.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.facens.registerevent.entities.Event;

public class EventDTO {
    private Long id;

    @NotBlank(message = "Preencher o nome.")
    @Length(min = 3, max = 50, message = "O nome deve ter no minino 3 caracteres e no maximo 50 caracteres.")
    private String name;


    @NotBlank(message = "Preencher a descrição.")
    @Length(min = 3, max = 70, message = "A descrição deve ter no minino 3 caracteres e no maximo 70 caracteres.")
    private String description;
    
    @Email
    private String emailContact;


   
    public EventDTO(){
    }
    public EventDTO(Long id, String name, String description, String emailContact) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.emailContact = emailContact;
        
    }
    public EventDTO(Event reg) {
        this.id = reg.getId();
        this.name = reg.getName();
        this.description = reg.getDescription();
        this.emailContact = reg.getEmailContact();
    }

    // Metodos Getters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getEmailContact() {
        return emailContact;
    }

    // Metodos Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }    
    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }  



}
