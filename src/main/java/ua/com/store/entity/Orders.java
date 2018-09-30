package ua.com.store.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime localDateTime;
    private int totalPrice;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(name = "OrderProduct", joinColumns = @JoinColumn(name = "OrderID"), inverseJoinColumns = @JoinColumn(name = "ProductID"))
    private List<Product> products = new ArrayList<>();



    public Orders(LocalDateTime localDateTime, int totalPrice) {
        this.localDateTime = localDateTime;
        this.totalPrice = totalPrice;
    }



}
