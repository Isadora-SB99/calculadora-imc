package redoing.imc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import redoing.imc.model.User;

@Repository
public interface UsuarioRepository extends JpaRepository<User, String> {

    User findByUsername (String username);
}
