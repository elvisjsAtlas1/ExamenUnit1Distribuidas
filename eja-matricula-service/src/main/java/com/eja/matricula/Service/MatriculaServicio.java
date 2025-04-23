package com.eja.matricula.Service;


import com.eja.matricula.Entity.Matricula;

import java.util.List;

public interface MatriculaServicio {


    List<Matricula> Listar();
    Matricula Buscar(Long id);
    Matricula Guardar(Matricula matricula);
    Matricula Actualizar(Matricula matricula);
    Matricula Eliminar(Matricula matricula);


}