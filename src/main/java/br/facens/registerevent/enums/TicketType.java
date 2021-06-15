package br.facens.registerevent.enums;


public enum TicketType {
    FREE("Free"),
    PAYED("Payed");

    private TicketType(String description) {
        this.description = description;
    }

    private final String description;

    public String getDescription() {
        return description;
    }

}
