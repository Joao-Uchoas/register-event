package br.facens.registerevent.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import br.facens.registerevent.entities.Register;

public class RegisterDTO {
    private Long id;
    private String name;
    private String description;
    private String place;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;

   
    public RegisterDTO(){
    }
    public RegisterDTO(Long id, String name, String description, String place, LocalDate startDate, LocalDate endDate,
                        LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.place = place;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public RegisterDTO(Register reg) {
        this.id = reg.getId();
        this.name = reg.getName();
        this.description = reg.getDescription();
        this.place = reg.getPlace();
        this.startDate = reg.getStartDate();
        this.endDate = reg.getEndDate();
        this.startTime = reg.getStartTime();
        this.endTime = reg.getEndTime();
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
    public String getPlace() {
        return place;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
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
    public void setPlace(String place) {
        this.place = place;
    }    
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }    
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }    
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }    
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }


}
