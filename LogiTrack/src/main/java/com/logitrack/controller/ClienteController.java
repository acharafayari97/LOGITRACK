package com.logitrack.controller;

import com.logitrack.entity.Cliente;
import com.logitrack.entity.Fornitori;
import com.logitrack.service.ClienteService;
import com.logitrack.service.FornitoriService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/clienti")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("clientiList", clienteService.getAllClienti());
        return "clienti/list"; // templates/cliente/list.html
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clienti/form"; // templates/cliente/form.html
    }

    @PostMapping
    public String create(@ModelAttribute("cliente") Cliente c) {
        clienteService.salvaCliente(c);
        return "redirect:/cliente";
    }
}
