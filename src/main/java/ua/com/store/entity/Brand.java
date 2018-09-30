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
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameOfBrand;
    private String brandImage;

    @ManyToOne
    private Country country;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "BrandProduct", joinColumns = @JoinColumn(name = "BrandID"),
            inverseJoinColumns = @JoinColumn(name = "ProductID"))
    private Set<Product> products = new HashSet<Product>();



    public Brand(String nameOfBrand, String brandImage) {
        this.nameOfBrand = nameOfBrand;
        this.brandImage = brandImage;
    }
}
