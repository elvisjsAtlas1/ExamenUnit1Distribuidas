package com.eja.course.Repository;

import com.eja.course.Entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepositorio extends JpaRepository<Curso, Long> {
}
