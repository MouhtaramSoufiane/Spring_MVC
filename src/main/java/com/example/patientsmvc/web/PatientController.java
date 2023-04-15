package com.example.patientsmvc.web;

import com.example.patientsmvc.entities.Patient;
import com.example.patientsmvc.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping(path = "/index")
    public String patients(Model model, @RequestParam(name = "page" ,defaultValue = "0") int page,@RequestParam(name = "keyword" ,defaultValue = "") String keyword, @RequestParam(name = "size" ,defaultValue = "5") int size){
        Page<Patient> pagePatients=patientRepository.findByNameContains(keyword,PageRequest.of(page, size));
        model.addAttribute("listPatients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "patients";
    }
    @GetMapping("/delete")
  public String delete(Long id,String keyword,int page){
        patientRepository.deleteById(id);
        return "redirect:index?keyword="+keyword+"&page="+page;
  }
   @GetMapping("/")
    public String home(){
        return "redirect:index";
    }
}
