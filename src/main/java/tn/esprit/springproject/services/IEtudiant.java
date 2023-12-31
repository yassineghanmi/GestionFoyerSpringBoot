package tn.esprit.springproject.services;

import tn.esprit.springproject.entites.Etudiant;
import tn.esprit.springproject.entites.Foyer;

import java.util.List;

public interface IEtudiant {

    public Etudiant addEtudiant(Etudiant E);
    public Etudiant updateEtudiant(long idE,Etudiant E);
    public List<Etudiant> findAllEtudiant();
    public Etudiant findEtudiant(long idE);
    public void deleteEtudiant (long idE);
}
