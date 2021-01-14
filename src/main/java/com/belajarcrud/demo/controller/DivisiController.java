package com.belajarcrud.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.belajarcrud.demo.dto.DivisiDto;
import com.belajarcrud.demo.entity.Divisi;
import com.belajarcrud.demo.service.DivisiService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Edric
 */
@Controller
public class DivisiController {

    @Autowired
    private DivisiService divisiService;

    @GetMapping("/divisi")
    public String index(Model model) {
        model.addAttribute("listDivisi", divisiService.getall());
        return "divisi/index";

    }

    @GetMapping("/divisi/create")
    public String create(Model model) {
        model.addAttribute("divisiDto", new DivisiDto());
        return "divisi/form";

    }

    @PostMapping("/divisi/create")
    public String save(@Valid @ModelAttribute("divisiDto") DivisiDto divisiDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "divisi/form";
        }
        Divisi divisi = new Divisi();
        divisi.setKode(divisiDto.getKode());
        divisi.setKeterangan(divisiDto.getKeterangan());
        divisiService.save(divisi);
        return "redirect:/divisi";
    }

    @GetMapping("/divisi/delete/{divisi.nomor}")
    public String delete(@PathVariable("divisi.nomor") int nomor) {
        divisiService.delete(nomor);
        return "redirect:/divisi";

    }

    @GetMapping("/divisi/edit/{divisi.nomor}")
    public String edit(@PathVariable("divisi.nomor") int nomor, Model model) {
        DivisiDto divisiDto = new DivisiDto();
        Divisi divisi = divisiService.findById(nomor);
        divisiDto.setKode(divisi.getKode());
        divisiDto.setKeterangan(divisi.getKeterangan());
        model.addAttribute("divisiDto", divisiDto);
        return "divisi/form";
    }

    @PostMapping("/divisi/edit/{divisi.nomor}")
    public String saveedit(@PathVariable("divisi.nomor") int nomor, @Valid @ModelAttribute("divisiDto") DivisiDto divisiDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "divisi/form";
        }
        Divisi divisi = divisiService.findById(nomor);
        divisi.setKode(divisiDto.getKode());
        divisi.setKeterangan(divisiDto.getKeterangan());
        divisiService.save(divisi);
        return "redirect:/divisi";
    }
}
