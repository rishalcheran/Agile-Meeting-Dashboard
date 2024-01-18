package net.javaguides.amd.repository;

import net.javaguides.amd.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {

    List<Notes> findByUser(String user);

    // Add more custom queries as needed
}
