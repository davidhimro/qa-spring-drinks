package com.qa.wine.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class WineList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="wine_name")
    private String wineName;

    @Column(name="grape_type")
    private String grapeType;

    @Column(name="country")
    private String country;

    //public User() {}

    public WineList(String wineName, String grapeType, String country) {
        this.wineName = wineName;
        this.grapeType = grapeType;
        this.country = country;
    }

    // For testing

    public WineList(long id, String wineName, String grapeType, String country) {
        this.id = id;
        this.wineName = wineName;
        this.grapeType = grapeType;
        this.country = country;
    }

    public WineList() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWineName() {
        return wineName;
    }

    public void setWineName(String wineName) {
        this.wineName = wineName;
    }

    public String getGrapeType() {
        return grapeType;
    }

    public void setGrapeType(String grapeType) {
        this.grapeType = grapeType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WineList wineList = (WineList) o;
        return Objects.equals(wineName, wineList.wineName) && Objects.equals(grapeType, wineList.grapeType) && Objects.equals(country, wineList.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wineName, grapeType, country);
    }
}
