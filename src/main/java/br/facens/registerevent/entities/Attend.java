package br.facens.registerevent.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.facens.registerevent.dto.attend.AttendInsertDTO;

@Entity
@Table(name = "TB_ATTENDEE")
@PrimaryKeyJoinColumn(name = "BASEUSER_ID")
public class Attend extends BaseUser {
    
    private Double balance;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "TICKET_ID")
    private List<Ticket> tickets;

    public Attend() {
    }

    public Attend(Long id, String name, String email, double balance) {
        super(id, name, email);
        this.balance = balance;
    }

    public Attend(AttendInsertDTO dto) {
        super.setName(dto.getName());
        super.setEmail(dto.getEmail());
        this.balance = dto.getBalance();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTickets(Ticket ticket) {
        this.tickets.add(ticket);
    }
    
}
