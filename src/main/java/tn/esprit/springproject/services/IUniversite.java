package tn.esprit.springproject.services;

import tn.esprit.springproject.entites.Universite;

import java.util.List;

public interface IUniversite {
    List<Universite> getAllUniversite();
    Universite getUniversiteById(long id);
    Universite addUniversite(Universite universite);
    Universite updateUniversite(long id, Universite newUniversite);
    void deleteUniversite(long id);
}
