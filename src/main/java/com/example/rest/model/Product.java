package com.example.rest.model;

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
   private Boolean in_stock;
   @OneToMany(mappedBy ="product", fetch = FetchType.LAZY)
   private List<OrderDetail> orderDetailsList;
}
