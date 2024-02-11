package uz.rovshan.testtask2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.rovshan.testtask2.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
