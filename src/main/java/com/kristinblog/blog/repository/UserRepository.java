package com.kristinblog.blog.repository;

import com.kristinblog.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query(value = "SELECT * FROM users WHERE address = :address", nativeQuery = true)
    public Optional<User> findUserByAddress(@Param("address") String address);
}
