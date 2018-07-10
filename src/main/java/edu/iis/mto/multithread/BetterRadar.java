package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar {

    private PatriotBattery battery;
    private Executor egzekutor;

    public BetterRadar(PatriotBattery missle, Executor executor) {
        this.battery = missle;
        this.egzekutor = executor;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {
        Runnable launchPatriotTask = new Runnable() {

            @Override
            public void run() {
                battery.launchPatriot();
            }
        };
        egzekutor.execute(launchPatriotTask);
    }
}
