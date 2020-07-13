package com.example.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "customer")
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String middlename;
    private String adres;
    private String email;
    private String phone;
    @JsonIgnore
    @OneToMany(mappedBy ="customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Orders> orders;

    public Customer(String name, String surname, String middlename, String adres, String email, String phone){
        this.name=name;
        this.surname=surname;
        this.middlename=middlename;
        this.adres=adres;
        this.email=email;
        this.phone=phone;
    }
}

