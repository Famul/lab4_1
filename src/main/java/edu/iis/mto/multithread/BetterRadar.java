package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BetterRadar {
    private PatriotBattery battery;

    public BetterRadar(PatriotBattery missle) {
        this.battery = missle;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {
        ExecutorService egzekutor = Executors.newSingleThreadExecutor();
        
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
