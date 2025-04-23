package com.eja.matricula.Entity;

import com.eja.matricula.Dto.CursoDto;
import com.eja.matricula.Dto.EstudianteDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor // Si necesitas constructor sin argumentos
@AllArgsConstructor // Si quieres un constructor con todos los argumentos
@Builder
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Long id;

    private Integer cicloMatricula;

    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy") // Ejemplo de formato
    private LocalDate fechaMatricula;


    private Long cursoId;
    @Transient
    private CursoDto curso;

    private Long estudianteId;
    @Transient
    private EstudianteDto estudiante;
}
