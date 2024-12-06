package com.sportcenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportcenter.dto.PrenotazioniRequest;
import com.sportcenter.model.CampoSportivo;
import com.sportcenter.model.Prenotazioni;
import com.sportcenter.model.Utente;
import com.sportcenter.repository.CampoSportivoRepository;
import com.sportcenter.repository.PrenotazioniRepository;
import com.sportcenter.repository.UtenteRepository;

@Service
public class PrenotazioniService {
    @Autowired
    private CampoSportivoRepository campoSportivoRepository;
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private PrenotazioniRepository prenotazioniRepository;

    public Prenotazioni create(PrenotazioniRequest request) {
        Utente utente = utenteRepository.findById(request.getUtenteId()).get();

        CampoSportivo campoSportivo = campoSportivoRepository.findById(request.getCampoSportivoId()).get();

        Prenotazioni prenotazioniToSave = new Prenotazioni();

        prenotazioniToSave.setDataOra(request.getDataOra());
        prenotazioniToSave.setStato(request.getStato());
        prenotazioniToSave.setUtente(utente);
        prenotazioniToSave.setCampoSportivo(campoSportivo);
        prenotazioniToSave = prenotazioniRepository.save(prenotazioniToSave); 
        return prenotazioniToSave;
    }
}
