package DAAII_T1_ALBERTO_GIRON.app_security.repository;

import DAAII_T1_ALBERTO_GIRON.app_security.model.bd.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository  extends JpaRepository< Rol, Integer> {
    Rol findByNomrol(String nomrol);
}
