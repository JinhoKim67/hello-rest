package com.ubisam.demo.api.users;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ubisam.demo.domain.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    
}
