package br.facens.registerevent.enums;

public enum Category {
    TEATRO("teatro"),
    CINEMA("cinema"),
    SHOW("show");

    private Category(String name) {
        this.name = name;
    }

    private final String name;

    public String getName() {
        return name;
    }

}
