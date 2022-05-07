package com.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "CONTINENTS", schema = "STUDENT")
@NamedQueries({
        @NamedQuery(name = "Continent.findAll",
                query = "select e from ContinentsEntity e order by e.name"),
        @NamedQuery(name = "Continent.findById",
                query = "select  e from ContinentsEntity e where e.id = :id"),
        @NamedQuery(name = "Continent.findByName ",
                query = "select e from ContinentsEntity e where e.name = :name")
})

public class ContinentsEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Basic
    @Column(name = "ID")
    private long id;
    @Basic
    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "continents")
    private Set<CountriesEntity> countriesEntitySet;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContinentsEntity that = (ContinentsEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContinentsEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
