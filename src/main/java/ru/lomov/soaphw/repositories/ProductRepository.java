package ru.lomov.soaphw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lomov.soaphw.entities.ProductEntity;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
