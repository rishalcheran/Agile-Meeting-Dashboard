package net.javaguides.amd.repository;

import net.javaguides.amd.entity.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
    // Add custom queries if needed
}
