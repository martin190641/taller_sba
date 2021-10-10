package pe.todotic.taller_sba.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @Column(nullable = false, length = 50)
    private String nombres;
    @Column(nullable = false, length = 50)
    private String apellidos;
    @Column(nullable = false, length = 101)
    private String nombreCompleto;
    @Column(nullable = false, unique = true, length = 50)
    private String email;
    @Column(length = 250)
    private String password;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    @Column(nullable = false)
    private LocalDateTime fechaRegistro;

    @PrePersist
    private void asignarDatosIniciales(){
        this.nombreCompleto = this.nombres + " " + this.apellidos;
        this.rol = Rol.CLIENTE;
        this.fechaRegistro = LocalDateTime.now();
    }

    @PreUpdate
    private void updateNombreCompleto(){
        this.nombreCompleto = this.nombres + " " + this.apellidos;
    }
}
