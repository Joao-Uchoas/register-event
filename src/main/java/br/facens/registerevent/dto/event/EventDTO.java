package br.facens.registerevent.dto.event;

import java.time.LocalTime;

import br.facens.registerevent.enums.Category;

import br.facens.registerevent.entities.Event;
import br.facens.registerevent.entities.Place;

public class EventDTO {
    private Long id;
    private Category category;
    private String name;
    private LocalTime startTime;
    private String emailContact;
    private Double priceTicket;

    private Place place;

    public EventDTO(){
    }
    public EventDTO(Long id, Category category, String name,LocalTime startTime, String emailContact, double priceTicket) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.startTime = startTime;
        this.emailContact = emailContact;
        this.priceTicket = priceTicket;
    }
    public EventDTO(Event reg) {
        this.id = reg.getId();
        this.category = reg.getCategory();
        this.name = reg.getName();
        this.startTime = reg.getStartTime();
        this.emailContact = reg.getEmailContact();
        this.priceTicket = reg.getPriceTicket();
        this.place = reg.getPlace();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

    public Double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(Double priceTicket) {
        this.priceTicket = priceTicket;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
