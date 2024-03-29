package uz.rovshan.testtask2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.rovshan.testtask2.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
