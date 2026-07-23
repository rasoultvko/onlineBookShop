package com.rsl.onlineshop.service.user;

import com.rsl.onlineshop.dto.request.UserRequest;
import com.rsl.onlineshop.dto.response.UserResponse;
import com.rsl.onlineshop.exception.RuleException;
import com.rsl.onlineshop.model.UserssDetails;
import com.rsl.onlineshop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse save(UserRequest userRequest) {

        Optional<UserssDetails> byUsername =
        userRepository.findByUsername(userRequest.getUsername());
        if(byUsername.isPresent())
            throw new RuleException("username.is.exist");
          return createUserResponse(userRepository.save(createUser(userRequest)));

    }


    private UserResponse createUserResponse (UserssDetails userssDetails){
        return  UserResponse.builder()
                .id(userssDetails.getId())
                .username(userssDetails.getUsername())
                .build();
    }

    private UserssDetails createUser (UserRequest userRequest ){
       return UserssDetails.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .build();
    }
}
