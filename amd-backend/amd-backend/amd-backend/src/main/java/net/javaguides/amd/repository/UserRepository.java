package net.javaguides.amd.repository;

import net.javaguides.amd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);

    boolean existsByEmail(String email);

    List<User> findByEmail(String email);

    // Add more custom queries as needed
}

