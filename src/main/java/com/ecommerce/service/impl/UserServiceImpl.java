package com.ecommerce.service.impl;

import com.ecommerce.dto.UserrDto;
import com.ecommerce.model.*;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.UserrRepository;
import com.ecommerce.service.UserService;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Inject
    private UserrRepository userRepository;

    @Inject
    private CartRepository cartRepository;

    @Inject
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserrDto userDto) {
        Userr user = new Userr();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(Arrays.asList(new Role("USER")));
        userRepository.save(user);
    }

    @Override
    public void updateUser(long id, Userr updateUser) {
        Userr oldUser = getUser(id);
        oldUser.setName(updateUser.getName());
        oldUser.setPassword(updateUser.getPassword());
        oldUser.setEmail(updateUser.getEmail());
        //saveUser(updateUser);
    }

    @Override
    public void deleteUser(Userr user) {
        userRepository.delete(user);
    }

    @Override
    public Userr getUser(long id) {
        Optional<Userr> optional = userRepository.findById(id);
        Userr user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException("User not found id:" + id);
        }
        return user;
    }
}
