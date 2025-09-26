package com.logitrack.controller;

import com.logitrack.entity.Fornitori; // usa un solo package!
import com.logitrack.service.FornitoriService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fornitori")
public class FornitoriController {

    private final FornitoriService fornitoriService;

    public FornitoriController(FornitoriService fornitoriService) {
        this.fornitoriService = fornitoriService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("fornitoriList", fornitoriService.getAllFornitori());
        return "fornitori/list"; // templates/fornitori/list.html
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("fornitore", new Fornitori());
        return "fornitori/form"; // templates/fornitori/form.html
    }

    @PostMapping
    public String create(@ModelAttribute("fornitore") Fornitori f) {
        fornitoriService.salvaFornitore(f);
        return "redirect:/fornitori";
    }
}
