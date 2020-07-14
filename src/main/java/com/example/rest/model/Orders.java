package com.example.rest.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Orders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate order_date;
    @Enumerated(EnumType.STRING)
    private Order_status order_status;
    @Enumerated(EnumType.STRING)
    private Payment_method payment_method;
    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    @JsonIgnore
    @OneToMany(mappedBy ="orders", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<OrderDetail> orderDetailList;

    public Orders(LocalDate order_date, Order_status order_status, Payment_method payment_method, Customer customer){
        this.order_date=order_date;
        this.order_status=order_status;
        this.payment_method=payment_method;
        this.customer=customer;
    }
}
