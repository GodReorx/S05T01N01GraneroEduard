package cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.controllers;

import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.domain.Office;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.dto.OfficeDTO;
import cat.itacademy.barcelonactiva.granero.eduard.s05.t01.n01.S05T01N01GraneroEduard.model.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/sucursal")
public class OfficeController {
    @Autowired
    private OfficeService officeService;

    @PostMapping("/add")
    public ResponseEntity<OfficeDTO> addOffice (@RequestBody Office office){
        return ResponseEntity.ok().body(officeService.addOffice(office));
    }

    @PutMapping("/update")
    public ResponseEntity<OfficeDTO> updateOffice (@RequestBody Office office){
        return ResponseEntity.ok().body(officeService.updateOffice(office));
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteOffice (@PathVariable("id") Integer officeId){
        boolean doIt = officeService.deleteOffice(officeId);
        if(doIt){
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<OfficeDTO> getOneOffice (@PathVariable("id") Integer officeId){
        return ResponseEntity.ok().body(officeService.getOneOffice(officeId));
    }

    @GetMapping("/getAll")
    public ModelAndView getAllOffice (Model model){
        List<OfficeDTO> officeList = officeService.getAllOffice();
        model.addAttribute("titulo","Office List");
        model.addAttribute("offices", officeList);
        return new ModelAndView("sucursal/listado",model.asMap());
    }
}
