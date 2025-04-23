package com.eja.matricula.Feign;

import com.eja.matricula.Dto.CursoDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="eja-course-service", path = "/curso")
public interface CursoFeign {
    @GetMapping("/{id}")
    public ResponseEntity<CursoDto> buscarCurso(@PathVariable Long id);
}