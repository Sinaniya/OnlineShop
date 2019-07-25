package com.example.demo.repository;

import com.example.demo.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {

    Optional<Basket> findBasketById(long id);
    Optional<Basket> findBasketByName(String Name);

    @Query("select b from Basket b where b.name like :name%")
    List<Basket> findBasketsByName(@Param("name") String name);
}