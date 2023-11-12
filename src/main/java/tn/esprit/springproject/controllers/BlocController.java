package tn.esprit.springproject.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.springproject.entites.Bloc;
import tn.esprit.springproject.entites.TypeChambre;
import tn.esprit.springproject.services.BlocServiceImp;
import tn.esprit.springproject.services.FoyerServicelmp;

import java.util.Set;

@RestController
public class BlocController {

    @Autowired
    private BlocServiceImp blocServiceImp;


    @GetMapping("getbytypec/{typeC}")
    public Set<Bloc> findByChamberTypeC(@PathVariable TypeChambre typeC){
        System.out.println(typeC);
        return blocServiceImp.findByChamberTypeC(typeC);
    }


}
