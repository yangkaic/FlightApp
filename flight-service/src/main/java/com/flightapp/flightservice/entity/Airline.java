package com.flightapp.flightservice.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "airline")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "write_up")
    private String writeUp;

    @Column(name = "is_block")
    private boolean isBlock;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "airline_id")
    private List<Flight> flights;

    public Airline() {
    }

    public Airline(String name, String contactNumber, String writeUp, boolean isBlock) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.writeUp = writeUp;
        this.isBlock = isBlock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getWriteUp() {
        return writeUp;
    }

    public void setWriteUp(String writeUp) {
        this.writeUp = writeUp;
    }

    public boolean isBlock() {
        return isBlock;
    }

    public void setBlock(boolean block) {
        isBlock = block;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    // add convenience methods for adding flight

    public void addFlight(Flight flight) {
        if (this.flights == null) {
            this.flights = new ArrayList<>();
        }
        this.flights.add(flight);
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", writeUp='" + writeUp + '\'' +
                ", isBlock=" + isBlock +
                '}';
    }
}
