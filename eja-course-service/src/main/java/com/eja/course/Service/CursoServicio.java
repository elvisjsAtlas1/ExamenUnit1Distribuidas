package com.eja.course.Service;

import com.eja.course.Entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoServicio {
    List<Curso> Listar();
    Optional<Curso> Buscar(Long id);
    Curso Guardar(Curso curso);
    Curso Modificar(Long id, Curso curso);
    void Eliminar(Long id);

}
