package br.facens.registerevent.dto.event;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.facens.registerevent.enums.Category;
import org.hibernate.validator.constraints.Length;

import jdk.jfr.Timestamp;

public class EventInsertDTO {

    private Category category;
    private String name;


    private LocalTime startTime;

    private LocalTime endTime;


    private String emailContact;

    
    private Long amountVIPTickets;
    
    private Long amountCommonTickets;

    private double priceTicket;

    private List<SeatDTO> seats;


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

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

    public Long getAmountVIPTickets() {
        return amountVIPTickets;
    }

    public void setAmountVIPTickets(Long amountVIPTickets) {
        this.amountVIPTickets = amountVIPTickets;
    }

    public Long getAmountCommonTickets() {
        return amountCommonTickets;
    }

    public void setAmountCommonTickets(Long amountCommonTickets) {
        this.amountCommonTickets = amountCommonTickets;
    }

    public double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(double priceTicket) {
        this.priceTicket = priceTicket;
    }

    public List<SeatDTO> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatDTO> seats) {
        this.seats = seats;
    }
}
