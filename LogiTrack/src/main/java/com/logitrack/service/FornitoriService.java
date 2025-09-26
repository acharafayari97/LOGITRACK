package com.logitrack.service;

import com.logitrack.entity.Fornitori;
import com.logitrack.repository.FornitoriRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornitoriService {
    private final FornitoriRepository fornitoriRepository;


    public FornitoriService(FornitoriRepository fornitoriRepository) {
        this.fornitoriRepository = fornitoriRepository;
    }

    public List<Fornitori> getAllFornitori(){
        return fornitoriRepository.findAll();
    }

    public Optional<Fornitori> getForntiriById(Long id){
        return fornitoriRepository.findById(id);
    }

    public Fornitori salvaFornitore(Fornitori fornitori){
        return fornitoriRepository.save(fornitori);
    }

    public Optional<Fornitori> aggiornaFornitori(Long id, Fornitori data){
        return fornitoriRepository.findById(id).map(existing -> {
            existing.setEmail(data.getEmail());
            existing.setTelefono(data.getTelefono());
            existing.setPartitaIva(data.getPartitaIva());
            return fornitoriRepository.save(existing);
        });
    }

    public void delateById(Long id){
        fornitoriRepository.deleteById(id);
    }
}
