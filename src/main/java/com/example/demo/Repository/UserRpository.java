package com.example.demo.Repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRpository extends JpaRepository<User, Long> {

    Optional<User> findUserById(long id);

    Optional findUserByUserName(String name);

@Query("select u from User u where u.userName like :name%")
List<User> findUsersByUserName(@Param("name") String name );
}
