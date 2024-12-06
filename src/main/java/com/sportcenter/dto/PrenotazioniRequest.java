package com.sportcenter.dto;

import java.time.LocalDateTime;

public class PrenotazioniRequest {
    private LocalDateTime dataOra;
    private String stato;
    private Long utenteId;
    private Long campoSportivoId;

   public void setCampoSportivoId(Long campoSportivoId) {
       this.campoSportivoId = campoSportivoId;
   }
   public Long getCampoSportivoId() {
       return campoSportivoId;
   }
   public void setUtenteId(Long utenteId) {
       this.utenteId = utenteId;
   }
   public Long getUtenteId() {
       return utenteId;
   }

    public void setDataOra(LocalDateTime dataOra) {
        this.dataOra = dataOra;
    }

    public LocalDateTime getDataOra() {
        return dataOra;
    }
   public void setStato(String stato) {
       this.stato = stato;
   }
   public String getStato() {
       return stato;
   }
}
