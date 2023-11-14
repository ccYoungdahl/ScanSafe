package com.userapi.app.rest.Repo;

import com.userapi.app.rest.UserModel.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
