package br.facens.registerevent.enums;


public enum TicketType {
    HOME("Home"),
    MOBILE("Mobile"),
    COMMERCIAL("Commercial");

    private TicketType(String description) {
        this.description = description;
    }

    private final String description;

    public String getDescription() {
        return description;
    }

}
