package com.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "COUNTRIES", schema = "STUDENT")
@NamedQueries({
        @NamedQuery(name = "Country.findByName",
                query = "SELECT e FROM CountriesEntity e WHERE e.name = :name"),
        @NamedQuery(name = "Country.findById",
                query = "select  e from CountriesEntity e where e.id = :id"),
        @NamedQuery(name = "Country.findByName ",
                query = "select e from CountriesEntity e where e.name = :name")
})


public class CountriesEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Basic
    @Column(name = "ID")
    private long id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "CODE")
    private String code;
    @Basic
    @Column(name = "CONTINENT")
    private String continent;

    @ManyToOne
    @JoinColumn(name = "CONTINENT_ID", nullable = false)
    private ContinentsEntity continents;

    @OneToMany(mappedBy = "countries")
    private Set<CitiesEntity> citiesEntitySet;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountriesEntity that = (CountriesEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (continent != null ? !continent.equals(that.continent) : that.continent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (continent != null ? continent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CountriesEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", continent='" + continent + '\'' +
                '}';
    }
}
