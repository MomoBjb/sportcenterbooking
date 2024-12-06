package com.sportcenter.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.sportcenter.model.CampoSportivo;
import com.sportcenter.model.Prenotazioni;
import com.sportcenter.model.Utente;
import com.sportcenter.repository.CampoSportivoRepository;
import com.sportcenter.repository.PrenotazioniRepository;
import com.sportcenter.repository.UtenteRepository;

public class PrenotazioniService {
    @Autowired
    private CampoSportivoRepository campoSportivoRepository;
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private PrenotazioniRepository prenotazioniRepository;

    public Prenotazioni create(PrenotazioniRequest request) {
        Utente utente = utenteRepository.findById(request.Utente)
        .orElseThrow(() -> new RuntimeException("ID_Utente not found"));

        CampoSportivo campoSportivo = campoSportivoRepository.findById(Id)
        .orElseThrow(() -> new RuntimeException("Campo Sportivo not found"));

        Prenotazioni prenotazioniToSave = new Prenotazioni();
        prenotazioniToSave.setStato(null);  //esempio, fai anche gli atri dati
        return prenotazioniRepository.save(prenotazioniToSave);
    }
}
