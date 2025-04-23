package com.eja.student.Repository;

import com.eja.student.Entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {
}
