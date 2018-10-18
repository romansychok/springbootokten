package ua.com.store.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

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
    @JoinTable(name = "ProductOrder" , joinColumns = @JoinColumn(name = "ProductID"))
    private Set<Orders> orders = new HashSet<>();

    @ManyToMany
    private Set<Brand> brands = new HashSet<>();

    public Product() {
    }

    public Product(String productName, String nameOfBrand, String description, int price, int quantity, String pathImage) {
        this.productName = productName;
        this.nameOfBrand = nameOfBrand;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.pathImage = pathImage;
    }

    public Product(String productName, String nameOfBrand, String description,
                   int price, int quantity, String pathImage, Category category) {
        this.productName = productName;
        this.nameOfBrand = nameOfBrand;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.pathImage = pathImage;
        this.category = category;
    }

    public Product(String brand, String details, int price, int quantity, String pathImage) {
        super();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getNameOfBrand() {
        return nameOfBrand;
    }

    public void setNameOfBrand(String nameOfBrand) {
        this.nameOfBrand = nameOfBrand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public Set<Brand> getBrands() {
        return brands;
    }

    public void setBrands(Set<Brand> brands) {
        this.brands = brands;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", nameOfBrand='" + nameOfBrand + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", pathImage='" + pathImage + '\'' +
                '}';
    }


}
