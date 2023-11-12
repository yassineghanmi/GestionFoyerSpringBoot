package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entites.Etudiant;
import tn.esprit.springproject.repositories.EtudiantRepositorie;
import java.util.List;


@Service
@AllArgsConstructor
public class EtudiantServiceImp implements IEtudiant {

    private final EtudiantRepositorie etudiantRepositorie;



    @Override
    public Etudiant addEtudiant(Etudiant E) {
        return etudiantRepositorie.save(E);
    }

    @Override
    public Etudiant updateEtudiant(long idE, Etudiant updatedEtudiant) {
        return etudiantRepositorie.saveAndFlush(updatedEtudiant);
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
