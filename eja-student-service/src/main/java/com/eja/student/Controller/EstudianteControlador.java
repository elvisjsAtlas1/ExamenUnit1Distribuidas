package com.eja.student.Controller;


import com.eja.student.Entity.Estudiante;
import com.eja.student.Service.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiante")
public class EstudianteControlador {
    @Autowired
    private EstudianteServicio estudianteServicio;

    // Listar todos los estudiantes
    @GetMapping
    public ResponseEntity<List<Estudiante>> listar() {
        return ResponseEntity.ok(estudianteServicio.Listar());
    }

    // Buscar estudiante por ID
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> buscar(@PathVariable Long id) {
        Optional<Estudiante> estudiante = estudianteServicio.Buscar(id);
        return estudiante.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Guardar nuevo estudiante
    @PostMapping
    public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante estudiante) {
        Estudiante nuevo = estudianteServicio.Guardar(estudiante);
        return ResponseEntity.ok(nuevo);
    }

    // Modificar estudiante existente
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> modificar(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        Estudiante actualizado = estudianteServicio.Modificar(id, estudiante);
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar estudiante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        estudianteServicio.Eliminar(id);
        return ResponseEntity.noContent().build();
    }


}