package com.rsl.onlineshop.service.user;

import com.rsl.onlineshop.dto.request.UserRequest;
import com.rsl.onlineshop.dto.response.UserResponse;
import com.rsl.onlineshop.model.UserssDetails;

public interface UserService {

    UserResponse save (UserRequest userRequest);
}
