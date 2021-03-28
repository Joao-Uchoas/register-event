package br.facens.registerevent.dto;

import br.facens.registerevent.entities.Register;

public class RegisterDTO {
    private Long id;
    private String name;
    private String description;
    private String emailContact;


   
    public RegisterDTO(){
    }
    public RegisterDTO(Long id, String name, String description, String emailContact) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.emailContact = emailContact;
        
    }
    public RegisterDTO(Register reg) {
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
