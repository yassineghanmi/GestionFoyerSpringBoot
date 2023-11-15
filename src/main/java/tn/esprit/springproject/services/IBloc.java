package tn.esprit.springproject.services;

import tn.esprit.springproject.entites.Bloc;
import tn.esprit.springproject.entites.Foyer;
import tn.esprit.springproject.entites.TypeChambre;

import java.util.List;
import java.util.Set;

public interface IBloc  {

    List<Bloc> getAllBloc();
    Bloc getBlocById(long id);
    Bloc addBloc(Bloc bloc);
    Bloc updateBloc(long id, Bloc newBloc);
    void deleteBloc(long id);
    Set<Bloc> findByChamberTypeC(TypeChambre typeC);
    Bloc findBlocByChambreId(long id);
}
