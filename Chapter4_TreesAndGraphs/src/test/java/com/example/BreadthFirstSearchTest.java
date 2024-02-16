package com.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BreadthFirstSearchTest {


    @Test
    void breadthFirstSearchTest() {
        BreadthFirstSearch.Node nodeA = new BreadthFirstSearch.Node("A");
        BreadthFirstSearch.Node nodeB = new BreadthFirstSearch.Node("B");
        BreadthFirstSearch.Node nodeC = new BreadthFirstSearch.Node("C");
        BreadthFirstSearch.Node nodeD = new BreadthFirstSearch.Node("D");
        BreadthFirstSearch.Node nodeE = new BreadthFirstSearch.Node("E");
        BreadthFirstSearch.Node nodeF = new BreadthFirstSearch.Node("F");
        BreadthFirstSearch.Node nodeG = new BreadthFirstSearch.Node("G");
        BreadthFirstSearch.Node nodeH = new BreadthFirstSearch.Node("H");
        BreadthFirstSearch.Node nodeI = new BreadthFirstSearch.Node("I");
        BreadthFirstSearch.Node nodeJ  = new BreadthFirstSearch.Node("J");
        BreadthFirstSearch.Node nodeK = new BreadthFirstSearch.Node("K");

        nodeA.addChild(nodeB);
        nodeA.addChild(nodeC);
        nodeA.addChild(nodeD);
        nodeB.addChild(nodeE);
        nodeB.addChild(nodeF);
        nodeD.addChild(nodeG);
        nodeD.addChild(nodeH);
        nodeF.addChild(nodeI);
        nodeF.addChild(nodeJ);
        nodeG.addChild(nodeK);


        final List<String> expected = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K");
        final List<String> result = nodeA.breadthFirstSearch(new ArrayList<>());

        MatcherAssert.assertThat(result, Matchers.equalTo(expected));
    }
}