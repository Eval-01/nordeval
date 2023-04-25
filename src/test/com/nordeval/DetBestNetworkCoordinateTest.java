package com.nordeval;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DetBestNetworkCoordinateTest extends TestCase {

    private DetBestNetworkCoordinate detBestNetworkCoordinate;

    @Before
    public void setUp() throws Exception {
        detBestNetworkCoordinate = new DetBestNetworkCoordinate();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calDistance() {
        double distance = detBestNetworkCoordinate.calDistance(15, 10, 10, 10);
        assertEquals(distance, 5.0, 0);
    }

    @Test
    public void calSpeed() {
        double distance = 5.0;
        double speed = detBestNetworkCoordinate.calSpeed(12, distance);
        assertEquals(speed, 49.0, 0);
    }

    @Test
    public void populateDevCoords() {
        ArrayList<DeviceNetworkCoord> networkDevCoords = detBestNetworkCoordinate.populateDevCoords();
        DeviceNetworkCoord networkDevCoord = networkDevCoords.get(3);

        assertEquals(networkDevCoord.getXcoord(), 18);
        assertEquals(networkDevCoord.getYcoord(), 18);
        assertEquals(networkDevCoord.getReach(), 13);
    }

    @Test
    public void findBestNetworkCoord() {
        ArrayList<DeviceNetworkCoord> networkDevCoords = detBestNetworkCoordinate.populateDevCoords();

        DeviceNetworkCoord deviceNetworkCoord = detBestNetworkCoordinate.findBestNetworkCoord(networkDevCoords, 10, 10);

        assertEquals(deviceNetworkCoord.getXcoord(), 15);
        assertEquals(deviceNetworkCoord.getYcoord(), 10);
        assertEquals(deviceNetworkCoord.getSpeed(), 49.0, 0);
    }
}