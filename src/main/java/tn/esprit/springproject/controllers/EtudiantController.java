package tn.esprit.springproject.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.entites.Etudiant;
import tn.esprit.springproject.entites.Etudiant;
import tn.esprit.springproject.services.EtudiantServiceImp;

import java.util.List;

@RestController
@AllArgsConstructor
public class EtudiantController  {

    private EtudiantServiceImp etudiantServiceImp;


    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant E){
        return etudiantServiceImp.addEtudiant(E);
    }
    @PutMapping("/updateEtudiant/{idE}")
    public Etudiant updateEtudiant(@PathVariable long idE,@RequestBody Etudiant E){
        return  etudiantServiceImp.updateEtudiant(idE,E);
    }
    @GetMapping("/getallEtudiant")
    public List<Etudiant> findAllEtudiant(){
        return etudiantServiceImp.findAllEtudiant();
    }
    @GetMapping("/get/{idE}")
    public  Etudiant findEtudiantById(@PathVariable long idE){
        return etudiantServiceImp.findEtudiant(idE);

    }
    @DeleteMapping("/delete/{idE}")
    public void deleateEtudiant(@PathVariable long idE){

        etudiantServiceImp.deleatEtudiant(idE);
    }
}
