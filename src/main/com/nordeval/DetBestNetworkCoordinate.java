package com.nordeval;

import java.util.ListIterator;
import java.util.Scanner;
import java.util.ArrayList;

public class DetBestNetworkCoordinate {

    static double calDistance(int x1, int y1, int x2, int y2) {
        return (Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)));
    }

    static double calSpeed(int reach, double distance) {
        return (distance > reach) ? 0 : Math.pow((reach - distance), 2);
    }

    static ArrayList<DeviceNetworkCoord> populateDevCoords() {
        ArrayList<DeviceNetworkCoord> test06DevCoords = new ArrayList<DeviceNetworkCoord>();

        test06DevCoords.add(new DeviceNetworkCoord(0, 0, 9));
        test06DevCoords.add(new DeviceNetworkCoord(100, 100, 6));
        test06DevCoords.add(new DeviceNetworkCoord(15, 10, 12));
        test06DevCoords.add(new DeviceNetworkCoord(18, 18, 13));
        test06DevCoords.add(new DeviceNetworkCoord(13, 13, 6));
        test06DevCoords.add(new DeviceNetworkCoord(99, 25, 2));

        return test06DevCoords;
    }

    static DeviceNetworkCoord findBestNetworkCoord(ArrayList networkDevCoords, int deviceXCoord, int deviceYCoord) {
        DeviceNetworkCoord bestNetworkDevCoord = null;
        double speed = -1, speed1 = -1, distance = -1;

        if(networkDevCoords != null) {
            ListIterator listItr = networkDevCoords.listIterator();

            while(listItr.hasNext()) {
                DeviceNetworkCoord devCoord = (DeviceNetworkCoord)listItr.next();

                distance = calDistance(devCoord.getXcoord(), devCoord.getYcoord(), deviceXCoord, deviceYCoord);
                speed1 = calSpeed(devCoord.getReach(), distance);

                if(speed1 > 0 && speed1 > speed) {
                    bestNetworkDevCoord = (devCoord);
                    speed = speed1;
                    bestNetworkDevCoord.setSpeed(speed);
                }
            }
        }

        return bestNetworkDevCoord;
    }

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter device's X point");
        int dx1=sc.nextInt();

        System.out.println("Enter device's Y point");
        int dy1=sc.nextInt();
		
		sc.close();

        ArrayList<DeviceNetworkCoord> networkDevCoords = populateDevCoords();

        DeviceNetworkCoord bestNetworkDevCoord = findBestNetworkCoord(networkDevCoords, dx1, dy1);

        if(bestNetworkDevCoord != null) {
            System.out.println("Best network station for point " + dx1 + ", " + dy1 + " is : " + bestNetworkDevCoord.getXcoord() + "," + bestNetworkDevCoord.getYcoord() + " with speed : " + bestNetworkDevCoord.getSpeed());
        } else {
            System.out.println("No network station within reach for point : " + dx1 + "," + dy1 );
        }


    }

}

class DeviceNetworkCoord {
    int XCoord = 0;
    int YCoord = 0;
    int reach = 0;

    double speed = -1;

    DeviceNetworkCoord(int x, int y, int r) {
        XCoord = x;
        YCoord = y;
        reach = r;
    }

    public int getXcoord() {
        return XCoord;
    }

    public int getYcoord() {
        return YCoord;
    }

    public int getReach() {
        return reach;
    }

    public void setSpeed(double s) {
        speed = s;
    }

    public double getSpeed() {
        return speed;
    }
}
