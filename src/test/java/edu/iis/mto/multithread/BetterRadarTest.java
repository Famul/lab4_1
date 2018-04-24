package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.concurrent.Executors;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

public class BetterRadarTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    /*
     * static PatriotBattery batteryMock; static BetterRadar radar;
     * 
     * @BeforeClass public static void setUp() { batteryMock = mock(PatriotBattery.class); radar = new
     * BetterRadar(batteryMock, Executors.newSingleThreadExecutor());
     * 
     * }
     */
    static PatriotBattery batteryMock;
    static BetterRadar radar;

    @AfterClass
    public static void tearDown() {
        batteryMock = null;
        radar = null;
    }

    @BeforeClass
    public static void setup() {
        batteryMock = mock(PatriotBattery.class);
        radar = new BetterRadar(batteryMock, Executors.newSingleThreadExecutor());
    }

    @Test
    @Repeat(times = 1000)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        radar.notice(new Scud());
        verify(batteryMock).launchPatriot();
    }

}
