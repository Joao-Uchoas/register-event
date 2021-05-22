package br.facens.registerevent.dto.place;


import br.facens.registerevent.entities.Place;

public class PlaceDTO {
    private Long id;
    private String name;

    public PlaceDTO() {
    }
    public PlaceDTO(Place reg) {
        this.id = reg.getId();
        this.name = reg.getName();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
