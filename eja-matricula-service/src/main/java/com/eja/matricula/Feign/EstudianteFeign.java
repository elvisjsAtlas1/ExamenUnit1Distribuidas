package com.eja.matricula.Feign;


import com.eja.matricula.Dto.EstudianteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="eja-student-service", path = "/estudiante")
public interface EstudianteFeign {
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDto> buscarEstudiante(@PathVariable Long id);
}