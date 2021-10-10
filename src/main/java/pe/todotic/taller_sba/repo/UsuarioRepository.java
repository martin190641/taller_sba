package pe.todotic.taller_sba.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.todotic.taller_sba.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
