package ru.gerch.justpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gerch.justpractice.models.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {
}
