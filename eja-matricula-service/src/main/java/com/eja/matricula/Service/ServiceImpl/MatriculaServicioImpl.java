package com.eja.matricula.Service.ServiceImpl;

import com.eja.matricula.Dto.CursoDto;
import com.eja.matricula.Dto.EstudianteDto;
import com.eja.matricula.Entity.Matricula;
import com.eja.matricula.Feign.CursoFeign;
import com.eja.matricula.Feign.EstudianteFeign;
import com.eja.matricula.Repository.MatriculaRepositorio;
import com.eja.matricula.Service.MatriculaServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatriculaServicioImpl implements MatriculaServicio {

    @Autowired
    private MatriculaRepositorio matriculaRepositorio;

    @Autowired
    private CursoFeign cursoFeign;

    @Autowired
    private EstudianteFeign estudianteFeign;

    @Override
    public List<Matricula> Listar() {
        return matriculaRepositorio.findAll().stream()
                .map(matricula -> {
                    matricula.setCurso(cursoFeign.buscarCurso(matricula.getCursoId()).getBody());
                    matricula.setEstudiante(estudianteFeign.buscarEstudiante(matricula.getEstudianteId()).getBody());
                    return matricula;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Matricula Buscar(Long id) {
        Optional<Matricula> matriculaOptional = matriculaRepositorio.findById(id);
        if (matriculaOptional.isPresent()) {
            Matricula matricula = matriculaOptional.get();
            matricula.setCurso(cursoFeign.buscarCurso(matricula.getCursoId()).getBody());
            matricula.setEstudiante(estudianteFeign.buscarEstudiante(matricula.getEstudianteId()).getBody());
            return matricula;
        }
        return null;
    }

    @Override
    public Matricula Guardar(Matricula matricula) {
        Matricula matriculaGuardada = matriculaRepositorio.save(matricula);
        matriculaGuardada.setCurso(cursoFeign.buscarCurso(matriculaGuardada.getCursoId()).getBody());
        matriculaGuardada.setEstudiante(estudianteFeign.buscarEstudiante(matriculaGuardada.getEstudianteId()).getBody());
        return matriculaGuardada;
    }

    @Override
    public Matricula Actualizar(Matricula matricula) {
        Matricula matriculaActualizada = matriculaRepositorio.save(matricula);
        matriculaActualizada.setCurso(cursoFeign.buscarCurso(matriculaActualizada.getCursoId()).getBody());
        matriculaActualizada.setEstudiante(estudianteFeign.buscarEstudiante(matriculaActualizada.getEstudianteId()).getBody());
        return matriculaActualizada;
    }

    @Override
    public Matricula Eliminar(Matricula matricula) {
        matriculaRepositorio.delete(matricula);
        return matricula;
    }
}