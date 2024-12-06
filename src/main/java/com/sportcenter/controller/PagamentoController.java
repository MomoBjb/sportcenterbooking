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

import com.sportcenter.model.Pagamento;
import com.sportcenter.repository.PagamentoRepository;

@RequestMapping("/api/Pagamento")
@RestController
public class PagamentoController {
      @Autowired
    private PagamentoRepository pagamentoRepository;

    @GetMapping
    public List<Pagamento> getAllPagamentos() {
        return pagamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pagamento getPagamento(@PathVariable Long id) {
        return pagamentoRepository.findById(id).get();
    }

    @PostMapping
    public Pagamento createPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pagamentoRepository.deleteById(id);

    }
}
