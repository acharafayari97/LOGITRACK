package com.logitrack.service;

import com.logitrack.entity.Cliente;
import com.logitrack.entity.Fornitori;
import com.logitrack.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAllClienti() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente salvaCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> aggiornaCliente(Long id, Cliente data) {
        return clienteRepository.findById(id).map(existing -> {
            existing.setRagioneSociale(data.getRagioneSociale());
            existing.setEmail(data.getEmail());
            existing.setPartitaIva(data.getPartitaIva());
            return clienteRepository.save(existing);
        });
    }

    public void eliminaCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
