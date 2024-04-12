package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.controllers;

import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.dto.OfficeDTO;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class WebController {

    @Autowired
    private OfficeService officeService;
    @GetMapping({"","/","/sucursal/index"})
    public String index(Model model) {
        return "redirect:/sucursal/getAll";
    }
}
