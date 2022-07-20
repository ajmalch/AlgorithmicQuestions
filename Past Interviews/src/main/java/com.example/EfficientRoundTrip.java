package com.example;

/*
You need to find  efficient round trip(one or more) for an aircraft could fly
You will be given two lists - one for forward journey  and other will be return journey
You will also be given maximum miles the aircraft could fly
For example, aircraft can fly a total of 10000 miles and list of distances are as follows.
Forward - [{1, 3000}, {2,2000}, {3, 7000}, {4, 4000}]
Return - [{1, 5000}, {2, 4000}, {3, 2000}, {4, 6000}]

So the answer would be [{1,4}, {4,1}, {3,3}] as all these combinations will give maximum running distance within the limit

 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static java.util.List.of;

public class EfficientRoundTrip {


    public static void main(String[] args) {

        System.out.println(getEfficientRoundTrips(of(of(1, 3000), of(2, 2000), of(3, 7000), of(4, 4000))
                , of(of(1, 5000), of(2, 4000), of(3, 7000), of(4, 6000))
                , 10000));


    }

    static List<List<Integer>> getEfficientRoundTrips(List<List<Integer>> forwardRoutes,
                                                      List<List<Integer>> returnRoutes,
                                                      int maximumDistance) {

        List<List<Integer>> efficientRoutes = new ArrayList<>();
        var currentMaxDistance = 0;

        ToIntFunction<List<Integer>> getDistanceFunction = route -> route.get(1);

        List<List<Integer>> sortedForwardRoutes = forwardRoutes.stream()
                .sorted(Comparator.comparingInt(getDistanceFunction)
                        .reversed())
                .collect(Collectors.toList());
        List<List<Integer>> sortedReturnRoutes = returnRoutes.stream()
                .sorted(Comparator.comparingInt(getDistanceFunction)
                        .reversed())
                .collect(Collectors.toList());

        System.out.println("Forward Routes sorted :" + sortedForwardRoutes);
        System.out.println("Return Routes sorted :" + sortedReturnRoutes);


//        final Iterator<List<Integer>> forwardIterator = sortedForwardRoutes.iterator();
//        final Iterator<List<Integer>> returnIterator = sortedReturnRoutes.iterator();

//        sortedForwardRoutes.forEach( route ->{
//            sortedReturnRoutes.forEach(returnRoute ->{
//
//                var routeDistance = route.get(1) + returnRoute.get(1);
//                if(routeDistance >= maximumDistance){
//                    if(routeDistance>currentMaxDistance){
//                        currentMaxDistance = routeDistance;
//                    }
//
//                }
//            });
//                }
//        );

        for (List<Integer> forwardRoute : sortedForwardRoutes) {

            for (List<Integer> returnRoute : sortedReturnRoutes) {

                var routeDistance = getDistanceFunction.applyAsInt(forwardRoute)
                        + getDistanceFunction.applyAsInt(returnRoute);
                if (routeDistance <= maximumDistance) {

                    if (routeDistance > currentMaxDistance) {
                        currentMaxDistance = routeDistance;
                        efficientRoutes.clear();
                        efficientRoutes.add(of(forwardRoute.get(0), returnRoute.get(0)));
                    } else if (routeDistance == currentMaxDistance) {
                        efficientRoutes.add(of(forwardRoute.get(0), returnRoute.get(0)));
                    } else
                        break;
                }

            }

        }


        return efficientRoutes;

    }
}
