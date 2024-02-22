package com.ecommerce.service;

import com.ecommerce.dto.UserrDto;
import com.ecommerce.model.Userr;

public interface UserService {

    void saveUser(UserrDto userDto);

    void updateUser(long id, Userr updateUser);

    void deleteUser(Userr user);

    Userr getUser(long id);

}
