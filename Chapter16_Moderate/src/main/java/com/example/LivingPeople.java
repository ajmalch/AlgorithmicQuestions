package com.example;

/*
Given a list of people with their birth and death years
Implement a method to compute the year with most people were alive.
All people were born between 1900 and 2000.
People who were born or die on a particular year should be considered as live for that year.
 */

import java.util.HashMap;
import java.util.Map;

public class LivingPeople {

    public static void main(String[] args) {

        Person p1 = new Person(12, 15);
        Person p2 = new Person(20, 90);
        Person p3 = new Person(10, 98);
        Person p4 = new Person(01, 72);
        Person p5 = new Person(10, 98);
        Person p6 = new Person(23, 82);
        Person p7 = new Person(13, 98);
        Person p8 = new Person(91, 98);
        Person p9 = new Person(83, 99);
        Person p10 = new Person(75, 94);
        Person p11 = new Person(94, 98);
        Person p12 = new Person(95, 98);
        Person p13 = new Person(96, 98);


        Person[] people = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13};


        System.out.println(maxAliveYear(people, 01, 99));


    }

    static int maxAliveYear(Person[] people, int min, int max) {

        if (min > max)
            throw new RuntimeException("minimum year cannot be greater than maximum year");
        int maxAliveYear = min;
        Map<Integer, Integer> yearMap = new HashMap<>();
        for (Person p : people) {
            yearMap.put(p.getBirth(), yearMap.getOrDefault(p.getBirth(), 0) + 1);
            yearMap.put(p.getDeath() + 1, yearMap.getOrDefault(p.getDeath() + 1, 0) - 1);
        }
        int maxLive = 0;
        int currentLive = 0;
        for (int i = min; i < max; i++) {
            if (yearMap.containsKey(i))
                currentLive += yearMap.get(i);
            if (currentLive > maxLive) {
                maxAliveYear = i;
                maxLive = currentLive;
            }

        }
        return maxAliveYear;
    }
}


class Person {

    private final int birth;
    private final int death;

    public int getBirth() {
        return birth;
    }

    public int getDeath() {
        return death;
    }

    public Person(int birth, int death) {
        this.birth = birth;
        this.death = death;
    }

}