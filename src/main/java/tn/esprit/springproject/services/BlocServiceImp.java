package tn.esprit.springproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.entites.Bloc;
import tn.esprit.springproject.entites.TypeChambre;
import tn.esprit.springproject.repositories.BlocRepositorie;
import tn.esprit.springproject.repositories.FoyerRepositorie;

import java.util.Set;

@Service
public class BlocServiceImp implements IBloc {
    @Autowired
    private BlocRepositorie blocRepositorie;


    @Override
    public Set<Bloc> findByChamberTypeC(TypeChambre typeC) {
        return blocRepositorie.findBlocsByChambresTypeC(typeC);
    }
}
