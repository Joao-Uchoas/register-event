package br.facens.registerevent.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.*;

import br.facens.registerevent.enums.Category;
import br.facens.registerevent.enums.TicketType;
@Entity
@Table(name = "TB_TICKET")
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_type")
    private TicketType ticketType;

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

}
