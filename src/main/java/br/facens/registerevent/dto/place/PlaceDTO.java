package br.facens.registerevent.dto.place;


import br.facens.registerevent.entities.Place;

public class PlaceDTO {
    private Long id;
    private String address;

    private String city;

    public PlaceDTO() {
    }
    public PlaceDTO(Place reg) {
        this.id = reg.getId();
        this.city = reg.getCity();
        this.address = reg.getAddress();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
}
