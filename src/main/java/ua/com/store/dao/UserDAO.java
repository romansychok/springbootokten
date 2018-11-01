package ua.com.store.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.store.entity.User;

import java.util.List;

public interface UserDAO extends JpaRepository<User,Integer>{

    @Query("from User u where u.username=:name")
    User findByUserName(@Param("name") String name);


    @Query("from User u where u.id=:id")
    User findOne(@Param("id") int id);

    @Query("select u from User u left join fetch u.products where u.id=:id")
    User findUserWithProduct(@Param("id") int id);

    @Query("select u from User  u left join fetch  u.orders o left join fetch o.products where u.id=:id")
    User findUserWithOrders(@Param("id") int id);

    @Query("select distinct u from User u left join fetch  u.orders")
    List<User> findAllWithOrders();

}
