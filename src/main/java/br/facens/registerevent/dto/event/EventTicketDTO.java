package br.facens.registerevent.dto.event;

import java.util.List;

import br.facens.registerevent.entities.Event;
import br.facens.registerevent.entities.Ticket;

public class EventTicketDTO {

    private Long amountFreeTickets;
    private Long amountPayedTickets;
    private Long freeTickectsSelled;
    private Long payedTickectsSelled;
    private List<Ticket> tickets;

    public EventTicketDTO(){
        
    }    
    public EventTicketDTO(Event event, Long free, Long payed) {
        this.amountFreeTickets = event.getAmountVIPTickets();
        this.amountPayedTickets = event.getAmountCommonTickets();
        this.freeTickectsSelled = free;
        this.payedTickectsSelled = payed;
        this.tickets = event.getTickets();
    }
    
    public EventTicketDTO(Event reg) {
        this.amountFreeTickets = reg.getAmountVIPTickets();
        this.amountPayedTickets = reg.getAmountCommonTickets();
        this.tickets = reg.getTickets();
    }


    public Long getAmountFreeTickets() {
        return amountFreeTickets;
    }
    public void setAmountFreeTickets(Long amountFreeTickets) {
        this.amountFreeTickets = amountFreeTickets;
    }
    public Long getAmountPayedTickets() {
        return amountPayedTickets;
    }
    public void setAmountPayedTickets(Long amountPayedTickets) {
        this.amountPayedTickets = amountPayedTickets;
    }
    public Long getFreeTickectsSelled() {
        return freeTickectsSelled;
    }
    public void setFreeTickectsSelled(Long freeTickectsSelled) {
        this.freeTickectsSelled = freeTickectsSelled;
    }
    public Long getPayedTickectsSelled() {
        return payedTickectsSelled;
    }
    public void setPayedTickectsSelled(Long payedTickectsSelled) {
        this.payedTickectsSelled = payedTickectsSelled;
    }
    public List<Ticket> getTickets() {
        return tickets;
    }
    public void addTickets(Ticket ticket) {
        this.tickets.add(ticket);
    }

}
