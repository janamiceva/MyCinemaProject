package mk.ukim.finki.wp.mycinema.repository;

import mk.ukim.finki.wp.mycinema.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUsernameAndPassword(String username,String password);
    Optional<User> findByUsername(String username);
}
