package com.eja.matricula.Repository;

import com.eja.matricula.Entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MatriculaRepositorio extends JpaRepository<Matricula, Long> {
}