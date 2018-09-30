package ua.com.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.store.dao.UserDAO;
import ua.com.store.entity.User;
import ua.com.store.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO dao;

    @Override
    public void save(User user) {
        dao.save(user);
    }
}
