package com.ufr.mim.angryballs.models;

import com.ufr.mim.angryballs.models.balloptions.Pilot;
import mesmaths.geometrie.base.Vecteur;

public interface StateClic {

    void run(Pilot pilot, Vecteur vecteur);

    class Play implements StateClic {

        @Override
        public void run(Pilot pilot, Vecteur vecteur) {
            Vecteur v = new Vecteur(vecteur.x/pilot.getMass(), vecteur.y/pilot.getMass());
            pilot.getAcceleration().ajoute(v);
            pilot.setState(this);
        }
    }

    class Stop implements StateClic {

        @Override
        public void run(Pilot pilot, Vecteur vecteur) {
            pilot.setState(this);
        }
    }
}
