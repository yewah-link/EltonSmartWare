package com.example.ELtonSmartWare.service;

import com.example.ELtonSmartWare.dto.SignupRequest;
import com.example.ELtonSmartWare.dto.UserDTO;
import com.example.ELtonSmartWare.entity.User; // Import your User entity class
import com.example.ELtonSmartWare.enums.UserRole;
import com.example.ELtonSmartWare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDTO createUser(SignupRequest signupRequest) {
        // Create a new User entity
        User user = new User();

        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setRole(UserRole.CUSTOMER);
        //user.createdUser = userRepository.save(user);


        UserDTO userDTO = new UserDTO();
        //userDTO.setId(createdUser.getId());

        return userDTO;
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
       // userDTO.setRole(user.getRole());
        // You can include other properties as needed
        return userDTO;
    }
}