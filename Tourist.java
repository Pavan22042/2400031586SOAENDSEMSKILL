package com.example.tourist.model;

import jakarta.persistence.*;

@Entity
public class Tourist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String destination;
    private String country;

    protected Tourist() {}
    public Tourist(String name, String destination, String country) {
        this.name = name; this.destination = destination; this.country = country;
    }
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDestination() { return destination; }
    public String getCountry() { return country; }
}
