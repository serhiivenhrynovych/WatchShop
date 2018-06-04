package ua.com.serhii.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.serhii.entity.User;

import java.util.Optional;

public interface UserDAO extends JpaRepository<User, Long> {
    @Query("from User u where u.username=:username")
    User findByName(@Param("username") String username);

    Optional<User> findOneByEmail(String email);
}
