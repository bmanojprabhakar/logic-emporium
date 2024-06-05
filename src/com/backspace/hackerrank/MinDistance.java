package com.backspace.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem Statement: Find the min distance between same
 * element in an array. If no similar element exists, return -1
 */
public class MinDistance {
    public static void main(String[] args) {
        System.out.println(findMinDistance());
    }

    public static int findMinDistance() {
        List<Integer> a = Arrays.asList(8, 1, 7, 2, 7, 8);
        int minDistance = Integer.MAX_VALUE;

        Map<Integer, Integer> directory = new HashMap<>();

        for(int i=0;i<a.size();i++) {
            int item = a.get(i);
            if(directory.containsKey(item)) {
                minDistance = Math.min(minDistance, i - directory.get(item));
            }

            directory.put(item, i);
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}
