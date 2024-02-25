package com.example;

/**
 * You're given two positive integers representing the height of a staircase and the maximum number of steps that you can advance up the staircase at a time. Write a function that returns the number of ways in which you can climb the staircase.
 * For example, if you were given a staircase of height = 3 and
 * maxSteps = 2 you could climb the staircase in 3
 * ways. You could take 1 step, 1 step, then 1 step, you could also take 1 step, then 2 steps, and you could take 2 steps, then 1 step.
 * Note that maxSteps <= height will always be true.
 */
public class StaircaseTraversal {

    //O(n) time complexity and O(n) space
    public int staircaseTraversal(int height, int maxSteps) {
        // Write your code here.
        return recurse (height, maxSteps, 0, 0);
    }


    private  int recurse(int height, int maxSteps,  int steps, int traversal){

        if(steps == height){
            traversal++;
            return traversal;
        }
        for(int i=1; i<=maxSteps; i++){
            if(steps+i <= height){
                traversal = recurse(height,maxSteps, steps+i, traversal);
            }
        }
        return traversal;
    }

}
