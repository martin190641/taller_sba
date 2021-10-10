package pe.todotic.taller_sba.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLibro;
    private String titulo;
    private Float precio;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    @PrePersist
    private void setFechaCracion(){
        setFechaCreacion(LocalDateTime.now());
    }

    @PreUpdate
    private void setActualizacion(){
        setFechaActualizacion(LocalDateTime.now());
    }
}
