package pe.todotic.taller_sba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.todotic.taller_sba.model.Libro;
import pe.todotic.taller_sba.repo.LibroRepository;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroRepository repository;

    @Autowired
    public LibroController(LibroRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Libro> index(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable Integer id){
        return repository.getById(id);
    }

    @PostMapping
    public Libro crear(@RequestBody Libro libro){
        return repository.save(libro);
    }

    @PutMapping("/{id}")
    public Libro crear(@PathVariable Integer id, @RequestBody Libro libroResquest){
        Libro libro = repository.getById(id);
        libro.setTitulo(libroResquest.getTitulo());
        libro.setPrecio(libroResquest.getPrecio());
        return repository.save(libro);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        repository.deleteById(id);
    }

}
