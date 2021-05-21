package br.facens.registerevent.entities;

import javax.persistence.Entity;

import br.facens.registerevent.dto.admin.AdminInsertDTO;

@Entity
public class Admin extends BaseUser{
    
    private String phoneNumber;

    public Admin() {
    }

    public Admin(Long id, String name, String email, String phoneNumber) {
        super(id, name, email);
        this.phoneNumber = phoneNumber;
    }
    public Admin(AdminInsertDTO dto) {
        super.setName(dto.getName());
        super.setEmail(dto.getEmail());
        this.phoneNumber = dto.getPhoneNumber();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
    
}
