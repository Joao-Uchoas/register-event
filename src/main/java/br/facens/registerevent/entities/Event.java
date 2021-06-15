package br.facens.registerevent.entities;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import br.facens.registerevent.dto.event.EventInsertDTO;
import jdk.jfr.Timestamp;

@Entity
@Table(name = "TB_EVENT")
public class Event implements Serializable{
   
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Preencher o nome.")
    @Length(min = 3, max = 50, message = "O nome deve ter no minino 3 caracteres e no maximo 50 caracteres.")
    private String name;
    @NotBlank(message = "Preencher a descrição.")
    @Length(min = 3, max = 70, message = "A descrição deve ter no minino 3 caracteres e no maximo 70 caracteres.")
    private String description;

    @DateTimeFormat(pattern = "yyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private LocalDate endDate;

    @Timestamp
    private LocalTime startTime;
    @Timestamp
    private LocalTime endTime;
    @Email
    private String emailContact;

    
    private Long amountFreeTickets;
    private Long amountPayedTickets;

    private Double priceTicket;

    @ManyToMany
    @JoinTable(
        name = "TB_EVENT_PLACE",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "place_id")
    )
    private List<Place> place = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "ADMIN_BASEUSER_ID")
    private Admin admin;
    
    @OneToMany
    @JoinColumn(name = "TICKET_ID")
    private List<Ticket> tickets;
    
    
// Metodos Constructs
    public Event() {
    }
    public Event(EventInsertDTO dto) {
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.startDate = dto.getStartDate();
        this.endDate = dto.getEndDate();
        this.startTime = dto.getStartTime();
        this.endTime = dto.getEndTime();
        this.emailContact = dto.getEmailContact();
        this.amountFreeTickets = dto.getAmountFreeTickets();
        this.amountPayedTickets = dto.getAmountPayedTickets();
        this.priceTicket = dto.getPriceTicket();
    }
    public Event(Event reg) {
        this.id = reg.getId();
        this.name = reg.getName();
        this.description = reg.getDescription();
        this.startDate = reg.getStartDate();
        this.startTime = reg.getStartTime();
        this.emailContact = reg.getEmailContact();
        this.priceTicket = reg.getPriceTicket();
        this.place = reg.getPlace();
        this.tickets = reg.getTickets();
    }

    


    // Metodos Getters
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
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
    public String getEmailContact() {
        return emailContact;
    }
    public Long getAmountFreeTickets() {
        return amountFreeTickets;
    }
    public Long getAmountPayedTickets() {
        return amountPayedTickets;
    }
    public double getPriceTicket() {
        return priceTicket;
    }
    public List<Place> getPlace() {
        return place;
    }
    public Admin getAdmin() {
        return admin;
    }
    public List<Ticket> getTickets() {
        return tickets;
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
    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }
    public void setAmountFreeTickets(Long amountFreeTickets) {
        this.amountFreeTickets = amountFreeTickets;
    }
    public void setAmountPayedTickets(Long amountPayedTickets) {
        this.amountPayedTickets = amountPayedTickets;
    }
    public void setPriceTicket(double priceTicket) {
        this.priceTicket = priceTicket;
    }
    public void addPlace(Place place) {
        this.place.add(place);
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    } 
    public void addTickets(Ticket ticket) {
        this.tickets.add(ticket);
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
    public void removePlace(Place place2) {
        this.place.remove(place2);
    }
    public void removeTicket() {
        this.tickets.removeAll(tickets);
    }
    
    

    
}