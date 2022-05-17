package com.example.demo.entity;

//clasa Person
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USERS", schema = "STUDENT")
public class UserEntity implements Serializable {
    private long idUser;
    private String name;

    @Id
    @Column(name = "ID_USER")
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}