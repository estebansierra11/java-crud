package co.com.Proyectoext.service.impl;

import co.com.Proyectoext.entity.User;

import java.util.List;

public interface UserService {

        User createUser(User user);
        User createtabla(User usuarios);
        User getUserById(Long userId);

        List<User> getAllUsers();

        User updateUser(User user);

        void deleteUser(Long userId);

}

