package ru.gerch.justpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gerch.justpractice.models.Human;

@Repository
public interface HumanRepository extends JpaRepository<Human, Long> {
    Human findHumanById(long id);
}
