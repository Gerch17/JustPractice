package ru.gerch.justpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gerch.justpractice.models.Human;

import java.util.List;

@Repository
public interface HumanRepository extends JpaRepository<Human, Long> {
    Human findHumanById(long id);

    List<Human> findHumansByAgeBetween(int from, int to);

    List<Human> findHumansByProfessionId(long id);

    List<Human> findHumansByIdIn(List<Long> id);

}
