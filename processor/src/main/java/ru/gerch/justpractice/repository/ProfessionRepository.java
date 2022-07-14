package ru.gerch.justpractice.repository;

import ru.gerch.justpractice.models.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionRepository extends JpaRepository<Profession, Long> {
    Profession findProfessionById(long id);

}
