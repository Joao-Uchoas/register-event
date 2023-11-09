package br.facens.registerevent.enums;


public enum TicketType {
    VIP("VIP"),
    COMUM("Comum");

    private TicketType(String description) {
        this.description = description;
    }

    private final String description;

    public String getDescription() {
        return description;
    }

}
