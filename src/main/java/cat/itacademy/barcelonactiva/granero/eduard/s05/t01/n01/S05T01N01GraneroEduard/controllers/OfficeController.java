package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.controllers;

import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.domain.Office;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.dto.OfficeDTO;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.services.OfficeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/sucursal")
public class OfficeController {
    @Autowired
    private OfficeService officeService;


    @GetMapping("/add")
    public ModelAndView newOffice (Model model){
        model.addAttribute("office", new Office());
        return new ModelAndView("sucursal/add",model.asMap());
    }

    @PostMapping("/add")
    public ModelAndView addOffice (@Valid @ModelAttribute Office office, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("office", new Office());
            model.addAttribute("error", "All fields are required. Please complete all fields.");
            return new ModelAndView("sucursal/add",model.asMap());

        }  else {
                OfficeDTO officeDTO = officeService.addOffice(office);
                return new ModelAndView("redirect:/sucursal/index",model.asMap());
        }
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdateOffice (@PathVariable("id") Integer officeId, Model model){
        model.addAttribute("office", officeService.getOneOffice(officeId));
        String updateUrl = "/sucursal/update/" + officeId;
        model.addAttribute("updateUrl", updateUrl);
        return new ModelAndView("sucursal/update",model.asMap());
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateOffice (@Valid @ModelAttribute Office office, BindingResult result, @PathVariable("id") Integer officeId, Model model){
        if(result.hasErrors()){
            model.addAttribute("error", "All fields are required. Please complete all fields.");
            return new ModelAndView("sucursal/update",model.asMap());
        } else{
            officeService.updateOffice(office);
            return new ModelAndView("redirect:/sucursal/index",model.asMap());
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteOffice (@PathVariable("id") Integer officeId, Model model){
        boolean doIt = officeService.deleteOffice(officeId);
        return new ModelAndView("redirect:/sucursal/index",model.asMap());
    }

    @GetMapping("/getOne")
    public ModelAndView getOneOffice(@RequestParam(value = "id") String officeId, Model model) {
        try {
            int id = Integer.parseInt(officeId);
            OfficeDTO officeDTO = officeService.getOneOfficeDTO(id);
            if (officeDTO != null) {
                model.addAttribute("offices", Arrays.asList(officeDTO));
            } else {
                model.addAttribute("message", "Office with ID " + id + " not found.");
            }
        } catch (NumberFormatException e) {
            model.addAttribute("message", "Insert a valid ID");
        } catch (Exception e) {
            model.addAttribute("message", "Office with id "+ officeId + " not found");
        }
        return new ModelAndView("sucursal/index", model.asMap());
    }

    @GetMapping("/getAll")
    public ModelAndView getAllOffice (Model model){
        List<OfficeDTO> officeList = officeService.getAllOffice();
        model.addAttribute("titulo","Office List");
        model.addAttribute("offices", officeList);
        return new ModelAndView("sucursal/index",model.asMap());
    }
}
