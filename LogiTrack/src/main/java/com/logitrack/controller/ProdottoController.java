package com.logitrack.controller;

import com.logitrack.entity.Prodotto;
import com.logitrack.service.ProdottoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prodotti")
public class ProdottoController {
    private final ProdottoService service;

    public ProdottoController(ProdottoService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("prodottiList", service.getAll());
        return "prodotti/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("prodotto", new Prodotto());
        return "prodotti/form";
    }

    @PostMapping
    public String create(@ModelAttribute("prodotto") Prodotto p) {
        service.save(p);
        return "redirect:/prodotti";
    }
}
