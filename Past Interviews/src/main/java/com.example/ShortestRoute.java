package com.example;

/*
Given a list of destinations as x,y coordinates from the origin
find the shortest route which covers X destinations where X is always less than or equal to size of the destination list.
Distance to a point from origin is SQRT(X^2+Y^2)
 */

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.sqrt;
import static java.util.List.of;
import static java.util.stream.Collectors.toList;

public class ShortestRoute {

    public static void main(String[] args) {

        List<List<Integer>> destinationList1 = of(of(1,1), of(2,3), of(3,3), of(-1, -1));

        System.out.println(shortestRoute(destinationList1, 3));
        System.out.println(shortestRoute(destinationList1, 2));

    }


    private static List<List<Integer>> shortestRoute(List<List<Integer>> allDestinations, int numOfDestinations){

        if(numOfDestinations > allDestinations.size() || numOfDestinations <=0) {
            throw new RuntimeException("number of destinations should be between 1 and  all destination list size ");
        }

        LinkedList<Destination> destinationSortedlist = new LinkedList();

        for(List<Integer> destination: allDestinations){

            Destination destinationObject = new Destination(destination);

            if(destinationSortedlist.size()<numOfDestinations)
                insertSorted(destinationSortedlist,destinationObject);
            else if(destinationSortedlist.getFirst().getDistance() >  destinationObject.getDistance()){

                destinationSortedlist.remove();
                insertSorted(destinationSortedlist, destinationObject);

            }

        }

        return destinationSortedlist.stream().map(Destination::getPoint).collect(toList());

    }

    private static void insertSorted(List<Destination> destinationSortedlist, Destination destination){


        if(destinationSortedlist.isEmpty()){

            destinationSortedlist.add(destination);
            return;
        }

        int i= 0;
        while(i<destinationSortedlist.size()){

            if(destinationSortedlist.get(i).getDistance() < destination.getDistance())
                break;
            i++;
        }

        destinationSortedlist.add(i,destination);

    }



}

class Destination{

    private final List<Integer> point;
    private final Double distance;

    List<Integer> getPoint() {
        return point;
    }

    Double getDistance() {
        return distance;
    }

    Destination(List<Integer> point) {
        this.point = point;
        this.distance = getDistance(point);
    }

    private static Double getDistance(List<Integer> point){

        return sqrt(point.get(0)* point.get(0) + point.get(1)*point.get(0));

    }
}
