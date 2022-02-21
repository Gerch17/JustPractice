package ru.gerch.justpractice.repository;

import org.springframework.data.jpa.repository.Query;
import ru.gerch.justpractice.models.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HumanRepository extends JpaRepository<Human, Long> {
    Human findHumanById(long id);;
}
