package br.facens.registerevent.entities;

import javax.persistence.Entity;

import br.facens.registerevent.dto.attend.AttendInsertDTO;

@Entity
public class Attend extends BaseUser {
    
    private Double balance;

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
    
}
