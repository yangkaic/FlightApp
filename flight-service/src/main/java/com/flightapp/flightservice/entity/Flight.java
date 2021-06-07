package com.flightapp.flightservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "from_place")
    private String fromPlace;

    @Column(name = "to_place")
    private String toPlace;

    @Column(name = "start_date_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startDateTime;

    @Column(name = "end_date_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endDateTime;

    @OneToOne(mappedBy = "flight") // refer to "flight" attribute in "Plane" class
    private Plane plane;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "ticket",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id")
    )
    private List<Passenger> passengerList;

    public Flight() {
    }

    public Flight(String fromPlace, String toPlace, Date startDateTime, Date endDateTime) {
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    @JsonIgnore
    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    // add a convenience method for adding passenger

    public void addPassenger(Passenger passenger) {

        if (passengerList == null) {
            passengerList = new ArrayList<>();
        }
        passengerList.add(passenger);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "fromPlace='" + fromPlace + '\'' +
                ", toPlace='" + toPlace + '\'' +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                '}';
    }
}
