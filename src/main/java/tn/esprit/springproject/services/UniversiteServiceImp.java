package tn.esprit.springproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entites.Universite;
import tn.esprit.springproject.repositories.UniversiteRepositorie;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImp implements IUniversite {

    private final UniversiteRepositorie universiteRepositorie;


    @Override
    public List<Universite> getAllUniversite() {
        return universiteRepositorie.findAll();
    }

    @Override
    public Universite getUniversiteById(long id) {
        return universiteRepositorie.findById(id).orElse(null);
    }

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepositorie.save(universite);
    }

    @Override
    public Universite updateUniversite(long id, Universite updatedUniversite) {
        Universite oldUniversite = getUniversiteById(id);
        if(oldUniversite != null){
            return universiteRepositorie.saveAndFlush(updatedUniversite);
        }
        return null;
    }

    @Override
    public void deleteUniversite(long id) {
        universiteRepositorie.deleteById(id);
    }
}
