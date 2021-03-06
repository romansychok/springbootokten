package ua.com.store.service;

import ua.com.store.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findByUserName(String name);
    void save(User user);
    void delete(User user);
    List<User> findAll();
    User findOne(int id);

}
