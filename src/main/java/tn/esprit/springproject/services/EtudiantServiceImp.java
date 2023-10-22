package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entites.Etudiant;
import tn.esprit.springproject.entites.Foyer;
import tn.esprit.springproject.repositories.EtudiantRepositorie;

import java.util.List;
@Service
@AllArgsConstructor
public class EtudiantServiceImp implements IEtudiant {

    private EtudiantRepositorie etudiantRepositorie;
    @Override
    public Etudiant addEtudiant(Etudiant E) {
        return etudiantRepositorie.save(E);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant E) {
        return etudiantRepositorie.saveAndFlush(E);
    }

    @Override
    public List<Etudiant> findAllEtudiant() {
        return etudiantRepositorie.findAll();
    }

    @Override
    public Etudiant findEtudiant(long idE) {
        return etudiantRepositorie.findById(idE).orElse(null);
    }

    @Override
    public void deleatEtudiant(long idE) {
        etudiantRepositorie.deleteById(idE);
    }
}
