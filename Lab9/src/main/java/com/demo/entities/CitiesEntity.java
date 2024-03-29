package com.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "CITIES", schema = "STUDENT")

@NamedQueries({
        @NamedQuery(name = "City.findByCountry",
                query = "select e from CitiesEntity e where e.country = :country"),
        @NamedQuery(name = "City.findById",
                query = "select  e from CitiesEntity e where e.id = :id"),
        @NamedQuery(name = "City.findByName ",
                query = "select e from CitiesEntity e where e.name = :name"),
        @NamedQuery(name = "City.findAll",
                query = "select e from CitiesEntity e order by e.name")
})

public class CitiesEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Basic
    @Column(name = "ID")
    private BigInteger id;
    @Basic
    @Column(name = "COUNTRY")
    private String country;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "CAPITAL")
    private BigInteger capital;
    @Basic
    @Column(name = "LATITUDE")
    private Double latitude;
    @Basic
    @Column(name = "LONGITUDE")
    private Double longitude;
    @Basic
    @Column(name = "POPULATION")
    private int population;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", nullable = false)
    private CountriesEntity countries;

    public CitiesEntity(){
    }

    public CitiesEntity(BigInteger id, String country, String name, BigInteger capital,
                        Double latitude, Double longitude, int population) {
        this.id = id;
        this.country = country;
        this.name = name;
        this.capital = capital;
        this.latitude = latitude;
        this.longitude = longitude;
        this.population = population;
    }

    public BigInteger getId() {
        return id;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getCountryname() {
        return country;
    }

    public void setCountryname(String countryname) {
        this.country = countryname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getCapital() {
        return capital;
    }

    public void setCapital(BigInteger capital) {
        this.capital = capital;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Object latitude) {
        this.latitude = (Double) latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Object longitude) {
        this.longitude = (Double) longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void assignToCountry(CountriesEntity country) {
        country.getCitiesEntitySet().add(this);
        this.countries = country;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CitiesEntity that = (CitiesEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (capital != null ? !capital.equals(that.capital) : that.capital != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CitiesEntity{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", capital=" + capital +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", population=" + population +
                ", country=" + countries +
                '}';
    }


}
