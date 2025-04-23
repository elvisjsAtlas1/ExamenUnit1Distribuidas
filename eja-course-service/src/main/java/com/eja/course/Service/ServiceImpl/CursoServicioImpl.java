package com.eja.course.Service.ServiceImpl;


import com.eja.course.Entity.Curso;
import com.eja.course.Repository.CursoRepositorio;
import com.eja.course.Service.CursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CursoServicioImpl implements CursoServicio {
    @Autowired
    private CursoRepositorio cursoRepositorio;

    @Override
    public List<Curso> Listar() {
        return cursoRepositorio.findAll();
    }

    @Override
    public Optional<Curso> Buscar(Long id) {
        return cursoRepositorio.findById(id);
    }

    @Override
    public Curso Guardar(Curso curso) {
        return cursoRepositorio.save(curso);
    }

    @Override
    public Curso Modificar(Long id, Curso curso) {
        curso.setId(id);
        return cursoRepositorio.save(curso);
    }

    @Override
    public void Eliminar(Long id) {
        cursoRepositorio.deleteById(id);
    }
}
