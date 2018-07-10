package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.concurrent.Executor;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class BetterRadarTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();
    PatriotBattery batteryMock;
    BetterRadar radar;

    @Before
    public void setUp() {
        Executor executor = Runnable::run;
        batteryMock = mock(PatriotBattery.class);
        radar = new BetterRadar(batteryMock, executor);
    }

    @Test
    @Repeat(times = 10000)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        radar.notice(new Scud());
        verify(batteryMock).launchPatriot();
    }

}
