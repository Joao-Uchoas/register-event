package br.facens.registerevent.dto.attend;

import br.facens.registerevent.entities.Attend;

public class AttendDTO {
    private Long id;
    private String name;
    private String email;


    public AttendDTO(){

    }
    public AttendDTO(Attend reg) {
        this.id = reg.getId();
        this.name = reg.getName();
        this.email = reg.getEmail();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }   
    
	

}
