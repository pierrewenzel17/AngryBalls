package com.ufr.mim.angryballs.models;

import com.ufr.mim.angryballs.models.balloptions.Pilot;

public interface StateClic {

    void run(Pilot pilot);

    class Play implements StateClic {

        @Override
        public void run(Pilot pilot) {
            System.out.println("Play");
            pilot.setState(this);
        }
    }

    class Stop implements StateClic {

        @Override
        public void run(Pilot pilot) {
            System.out.println("Pause");
            pilot.setState(this);
        }
    }
}
