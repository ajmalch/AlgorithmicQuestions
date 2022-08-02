package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * An array of integer is said to represent a BST if by inserting from left to right it would form a BST
 * <p>
 * Given two BST arrays, write a method to return if they represent the same BST
 * (meaning all nodes are exactly at same place)
 */
public class SameBST {


    public boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {

        if (arrayOne.size() != arrayTwo.size())
            return false;
        if (arrayOne.isEmpty())
            return true;
        if (!Objects.equals(arrayOne.get(0), arrayTwo.get(0)))
            return false;

        return sameBsts(getSmaller(arrayOne, arrayOne.get(0)), getSmaller(arrayTwo, arrayTwo.get(0)))
                && sameBsts(getBiggerOrEqual(arrayOne, arrayOne.get(0)), getBiggerOrEqual(arrayTwo, arrayTwo.get(0)));

    }

    private List<Integer> getBiggerOrEqual(List<Integer> list, Integer num) {

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            int n = list.get(i);
            if (n >= num)
                result.add(n);
        }
        return result;
    }

    private List<Integer> getSmaller(List<Integer> list, Integer num) {
        List<Integer> result = new ArrayList<>();
        for (int n : list) {
            if (n < num)
                result.add(n);
        }
        return result;
    }

}
