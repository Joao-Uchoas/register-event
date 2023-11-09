package br.facens.registerevent.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Length;

import br.facens.registerevent.dto.place.PlaceInsertDTO;

@Entity
@Table(name = "TB_PLACE")
public class Place implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Preencher o nome da cidade.")
    @Length(min = 3, max = 50, message = "O colocar no minimo 3 caracteres e no maximo 50.")
    private String city;
    @NotBlank(message = "Preencher o endereço do local.")
    @Length(min = 3, max = 50, message = "O colocar no minimo 3 caracteres e no maximo 50.")
    private String address;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "TB_EVENT_PLACE",
        joinColumns = @JoinColumn(name = "place_id"),
        inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> events = new ArrayList<>();

    public Place() {

    }
    public Place(PlaceInsertDTO dto){
        this.city = dto.getCity();
        this.address = dto.getAddress();
    }
    public Place(Place reg){
        this.id = reg.getId();
        this.city = reg.getCity();
        this.address = reg.getAddress();
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public List<Event> getEvents() {
        return events;
    }
    public void addEvent(Event event) {
        this.events.add(event);
    }

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
        Place other = (Place) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    public void removeEvent(Event event) {
        this.events.remove(event);
    }
}
