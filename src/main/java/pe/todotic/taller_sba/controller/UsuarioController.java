package pe.todotic.taller_sba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.todotic.taller_sba.model.Usuario;
import pe.todotic.taller_sba.repo.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Usuario> index(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable Integer id){
        return repository.findById(id);
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario){
        return repository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Integer id, @RequestBody Usuario usuarioResquest){
        Usuario usuario = repository.getById(id);
        usuario.setNombres(usuarioResquest.getNombres());
        usuario.setApellidos(usuarioResquest.getApellidos());
        usuario.setEmail(usuarioResquest.getEmail());
        usuario.setPassword(usuarioResquest.getPassword());
        return repository.save(usuario);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        repository.deleteById(id);
    }

}
