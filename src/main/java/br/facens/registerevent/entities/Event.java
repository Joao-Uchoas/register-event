package br.facens.registerevent.entities;


import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.facens.registerevent.enums.Category;
import br.facens.registerevent.enums.CategoryConverter;
import org.hibernate.validator.constraints.Length;

import br.facens.registerevent.dto.event.EventInsertDTO;
import jdk.jfr.Timestamp;

@Entity
@Table(name = "TB_EVENT")
public class Event implements Serializable{
   
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Convert(converter = CategoryConverter.class)
    @Column(name = "category")
    @NotNull(message = "Preencher o evento.")
    private Category category;
    @NotBlank(message = "Preencher o nome do evento.")
    @Length(min = 3, max = 50, message = "O nome do evento deve ter no minino 3 caracteres e no maximo 50 caracteres.")
    private String name;

    @Timestamp
    private LocalTime startTime;
    @Timestamp
    private LocalTime endTime;
    @Email
    private String emailContact;

    @Column(name = "amount_vip_tickets")
    private Long amountVIPTickets;
    private Long amountCommonTickets;

    private Double priceTicket;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;
    
    @ManyToOne
    @JoinColumn(name = "ADMIN_BASEUSER_ID")
    private Admin admin;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "event_id")
    private List<Seat> seats = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "TICKET_ID")
    private List<Ticket> tickets;

    
// Metodos Constructs
    public Event() {
    }
    public Event(EventInsertDTO dto) {
        this.category = dto.getCategory();
        this.name = dto.getName();
        this.startTime = dto.getStartTime();
        this.endTime = dto.getEndTime();
        this.emailContact = dto.getEmailContact();
        this.amountVIPTickets = dto.getAmountVIPTickets();
        this.amountCommonTickets = dto.getAmountCommonTickets();
        this.priceTicket = dto.getPriceTicket();
    }
    public Event(Event reg) {
        this.id = reg.getId();
        this.category = reg.getCategory();
        this.name = reg.getName();
        this.startTime = reg.getStartTime();
        this.emailContact = reg.getEmailContact();
        this.priceTicket = reg.getPriceTicket();
        this.place = reg.getPlace();
        this.tickets = reg.getTickets();
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
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

    public Double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(Double priceTicket) {
        this.priceTicket = priceTicket;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Place getPlace() {
        return place;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTickets(Ticket tickets) {
        this.tickets.add(tickets);
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public boolean isSeatAvailable(String row, Integer number) {
        return seats.stream()
                .anyMatch(seat -> seat.getRow().equals(row) &&
                        seat.getNumber().equals(number) &&
                        seat.getIsAvailable());
    }

    // Metodo hash e equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Event other = (Event) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    public void removeTicket() {
        this.tickets.removeAll(tickets);
    }

}