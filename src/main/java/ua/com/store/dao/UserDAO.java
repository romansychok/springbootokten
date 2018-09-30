package ua.com.store.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.store.entity.User;

public interface UserDAO extends JpaRepository<User,Integer>{
}
