package ua.com.serhii.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.serhii.entity.User;

public interface UserDAO extends JpaRepository<User, Long> {
}
