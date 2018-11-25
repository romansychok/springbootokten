package ua.com.store.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productName;
    private String nameOfBrand;
    private String description;
    private int price;
    private int quantity;
    private String pathImage;

    @ManyToOne
    private Category category;


    @ManyToMany
    @JoinTable(name = "UserProduct", joinColumns = @JoinColumn(name = "ProductID"), inverseJoinColumns = @JoinColumn(name = "UserID"))
    private Set<User> users = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "ProductOrder" , joinColumns = @JoinColumn(name = "ProductID"), inverseJoinColumns = @JoinColumn(name = "OrderID"))
    private Set<Orders> orders = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "BrandProduct", joinColumns = @JoinColumn(name = "ProductID"), inverseJoinColumns = @JoinColumn(name = "BrandID") )
    private Set<Brand> brands = new HashSet<>();


    public Product(String productName, String nameOfBrand, String description, int price, int quantity, Category category) {
        this.productName = productName;
        this.nameOfBrand = nameOfBrand;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public Product(String productName, String nameOfBrand, String description, int price, int quantity, String pathImage, Category category) {
        this.productName = productName;
        this.nameOfBrand = nameOfBrand;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.pathImage = pathImage;
        this.category = category;
    }






}
