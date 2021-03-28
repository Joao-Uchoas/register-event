package br.facens.registerevent.dto;

public class RegisterUpdateDTO {
    private String name;
    private String emailContact;
    
    public String getName() {
        return name;
    }
    public String getEmailContact() {
        return emailContact;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

}
