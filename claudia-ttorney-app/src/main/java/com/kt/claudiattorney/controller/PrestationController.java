package com.kt.claudiattorney.controller;

import com.kt.claudiattorney.entity.Case;
import com.kt.claudiattorney.entity.Prestation;
import com.kt.claudiattorney.repository.CaseRepository;
import com.kt.claudiattorney.repository.PrestationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("prestation")
public class PrestationController {

    private final PrestationRepository prestationRepository;
    private final CaseRepository caseRepository;

    @Autowired
    public PrestationController(PrestationRepository prestationRepository, CaseRepository caseRepository) {
        this.prestationRepository = prestationRepository;
        this.caseRepository = caseRepository;
    }

    @ModelAttribute("prestations")
    public List<Prestation> findAll() {
        return prestationRepository.findAll();
    }

    @GetMapping("/prestation")
    public String initView(Model model) {
        model.addAttribute(new Prestation());
        return "prestation";
    }

    @GetMapping(value = "/prestation/{caseId}/create")
    public String initCreateForm(@PathVariable("caseId") Long caseId, Model model) {
        Case aCase = caseRepository.findOne(caseId);
        Prestation prestation = new Prestation();
        prestation.setACase(aCase);
        model.addAttribute("prestation", prestation);
        return "prestation";
    }

    @PostMapping("/prestation")
    public String create(@Valid Prestation prestation, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "prestation";
        }
        prestationRepository.save(prestation);
        model.addAttribute("prestations", prestationRepository.findAll());
        return "prestation";
    }
}
