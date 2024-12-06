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

import com.sportcenter.model.Prenotazioni;
import com.sportcenter.repository.PrenotazioniRepository;

@RequestMapping("/api/Prenotazioni")
@RestController
public class PrenotazioniController {
     @Autowired
    private PrenotazioniRepository prenotazioniRepository;

    @GetMapping
    public List<Prenotazioni> getAllPrenotazionis() {
        return prenotazioniRepository.findAll();
    }

    @GetMapping("/{id}")
    public Prenotazioni getPrenotazioni(@PathVariable Long id) {
        return prenotazioniRepository.findById(id).get();
    }

    @PostMapping
    public Prenotazioni createPrenotazioni(@RequestBody Prenotazioni prenotazioni) {
        return prenotazioniRepository.save(prenotazioni);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        prenotazioniRepository.deleteById(id);

    }
}
