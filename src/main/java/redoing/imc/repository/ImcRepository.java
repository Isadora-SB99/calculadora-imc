package redoing.imc.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import redoing.imc.model.IMC;

import java.util.List;

@Repository
public interface ImcRepository extends JpaRepository<IMC, Integer> {

    @Query("select i from IMC i join i.user u where u.username = :username")
    List<IMC> findAllByUsuario(@Param("username") String username);

}
