package pe.todotic.taller_sba.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.todotic.taller_sba.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
