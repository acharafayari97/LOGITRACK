package com.logitrack.service;

import com.logitrack.entity.Prodotto;
import com.logitrack.repository.ProdottoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdottoService {
    private final ProdottoRepository repo;

    public ProdottoService(ProdottoRepository repo) {
        this.repo = repo;
    }

    public List<Prodotto> getAll() { return repo.findAll(); }
    public Optional<Prodotto> getById(Long id) { return repo.findById(id); }
    public Prodotto save(Prodotto p) { return repo.save(p); }

    public Optional<Prodotto> update(Long id, Prodotto data) {
        return repo.findById(id).map(existing -> {
            existing.setNome(data.getNome());
            existing.setCodice(data.getCodice());
            existing.setPrezzoUnitario(data.getPrezzoUnitario());
            existing.setQuantitaDisponibile(data.getQuantitaDisponibile());
            return repo.save(existing);
        });
    }

    public void delete(Long id) { repo.deleteById(id); }
}
