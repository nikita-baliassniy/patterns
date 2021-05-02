package ru.geekbrains.education.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.education.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
