package com.eja.course.Controller;

import com.eja.course.Entity.Curso;
import com.eja.course.Service.CursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursoControlador {

    @Autowired
    private CursoServicio cursoServicio;
        //OJO REVISAR AL FINAL
    // Listar todos los cursos
    @GetMapping
    public ResponseEntity<List<Curso>> listar() {
        return ResponseEntity.ok(cursoServicio.Listar());
    }

    // Buscar curso por ID
    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscar(@PathVariable Long id) {
        Optional<Curso> curso = cursoServicio.Buscar(id);
        return curso.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Guardar nuevo curso
    @PostMapping
    public ResponseEntity<Curso> guardar(@RequestBody Curso curso) {
        Curso nuevo = cursoServicio.Guardar(curso);
        return ResponseEntity.ok(nuevo);
    }

    // Modificar curso existente
    @PutMapping("/{id}")
    public ResponseEntity<Curso> modificar(@PathVariable Long id, @RequestBody Curso curso) {
        Curso actualizado = cursoServicio.Modificar(id, curso);
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar curso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cursoServicio.Eliminar(id);
        return ResponseEntity.noContent().build();
    }
}