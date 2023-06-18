package hr.tvz.spring.crnjak1.user;

import java.util.Optional;

public interface UserService {
    Optional<UserDTO> findByUsername(String username);
}