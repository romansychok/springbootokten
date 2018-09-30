package ua.com.store.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String username;
    private String password;
    private String repeatPassword;
    private String userImage;
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Orders> orders = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "UserProduct", joinColumns = @JoinColumn(name = "UserID"),
            inverseJoinColumns = @JoinColumn(name = "ProductID"))
    private Set<Product> products = new HashSet<>();


    public User(String username, String password) {
        this.username=username;
        this.password=password;
    }
}
