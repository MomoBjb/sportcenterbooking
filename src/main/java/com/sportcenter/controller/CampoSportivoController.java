package com.sportcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportcenter.model.CampoSportivo;
import com.sportcenter.repository.CampoSportivoRepository;

@RequestMapping("/api/CampoSportivo")
@RestController
public class CampoSportivoController {
    @Autowired
    private CampoSportivoRepository campoSportivoRepository;

    @GetMapping
    public List<CampoSportivo> getAllCampoSportivos() {
        return campoSportivoRepository.findAll();
    }

    @GetMapping("/{id}")
    public CampoSportivo getCampoSportivo(@PathVariable Long id) {
        return campoSportivoRepository.findById(id).get();
    }

    @PostMapping
    public CampoSportivo createCampoSportivo(@RequestBody CampoSportivo CampoSportivo) {
        return campoSportivoRepository.save(CampoSportivo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        campoSportivoRepository.deleteById(id);
    }
}
