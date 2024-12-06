package com.sportcenter.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportcenter.dto.PrenotazioneResponse;
import com.sportcenter.dto.PrenotazioniRequest;
import com.sportcenter.model.CampoSportivo;
import com.sportcenter.model.Prenotazioni;
import com.sportcenter.model.Utente;
import com.sportcenter.repository.PrenotazioniRepository;
import com.sportcenter.service.PrenotazioniService;



@RequestMapping("/api/Prenotazioni")
@RestController
public class PrenotazioniController {
     @Autowired
    private PrenotazioniRepository prenotazioniRepository;
    @Autowired
    private PrenotazioniService prenotazioniService;

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

    @PostMapping
    public PrenotazioneResponse create(@RequestBody PrenotazioniRequest prenotazioniRequest) {
        Prenotazioni prenotazione = prenotazioniService.create(prenotazioniRequest);
        
        PrenotazioneResponse response = new PrenotazioneResponse();

        response.setId(prenotazione.getId());
        response.setCampoSportivoResponseId(prenotazione.getCampoSportivo().getId());
        response.setUtenteResponseId(prenotazione.getUtente().getId());
        response.setDataOraResponse(prenotazione.getDataOra());
        response.setStatoResponse(prenotazione.getStato());
        return response;
    }
    
}
