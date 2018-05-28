package ua.com.serhii.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.serhii.entity.Basket;

public interface BasketDAO extends JpaRepository<Basket, Long> {
}
