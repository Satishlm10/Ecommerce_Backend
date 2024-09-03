package com.SmProjects.dreamshops.service.user;

import com.SmProjects.dreamshops.dto.UserDto;
import com.SmProjects.dreamshops.model.User;
import com.SmProjects.dreamshops.request.CreateUserRequest;
import com.SmProjects.dreamshops.request.UserUpdateRequest;

public interface IUserService {
    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(UserUpdateRequest request, Long userId);
    void deleteUser(Long userId);

    User getAuthenticatedUser();

    UserDto convertUserToDto(User user);
}
