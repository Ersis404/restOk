package com.example.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Product {

   @Id
   @GeneratedValue(generator = "increment")
   @GenericGenerator(name= "increment", strategy= "increment")
   private Long id;
   private String name;
   private Double price;
   private String description;
   private Boolean inStock;
   @JsonIgnore
   @OneToMany(mappedBy ="product",  fetch = FetchType.EAGER)
   private List<OrderDetail> orderDetailsList;
}
