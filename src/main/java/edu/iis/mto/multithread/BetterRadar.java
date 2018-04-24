package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;

public class BetterRadar {

    private PatriotBattery battery;
    private ExecutorService egzekutor;

    public BetterRadar(PatriotBattery missle, ExecutorService executor) {
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
        egzekutor.submit(launchPatriotTask);
        egzekutor.shutdown();
    }
}
