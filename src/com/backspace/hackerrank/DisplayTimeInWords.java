package com.backspace.hackerrank;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement: Print the input time which
 *  is in hh:mm format in words.
 *  - Minutes in 15, 30 should be spelt as quarter and half.
 *  Example:
 */
public class DisplayTimeInWords {
    public static void main(String[] args) {
        System.out.println(suggestedSolution_convertTimeToWords(12, 44));
    }

    public static String mySolution_convertTimeToWords(int h, int m) {
        String prefix = "to";
        String suffix = "past";
        String minutes_unit = "minute";

        Map<Integer, String> numbers = numberMinutesMapping();

        if((h > 12 || h<0) && (m < 0 || m > 66))
            throw new RuntimeException("Invalid input");

        StringBuilder output = new StringBuilder();

        if(m == 0)
            output.append(numbers.get(h)).append(" o' clock");
        else if(m == 15)
            output.append("quarter past ").append(numbers.get(h));
        else if(m == 30)
            output.append("half past ").append(numbers.get(h));
        else if(m == 45) {
            int nextTime = h+1;
            if(h == 12)
                nextTime = 1;
            output.append("quarter to ").append(numbers.get(nextTime));
        } else if(m < 30) {
            if(m > 1)
                minutes_unit += "s";
            output.append(numbers.get(m)).append(" ")
                    .append(minutes_unit).append(" ")
                    .append(suffix).append(" ")
                    .append(numbers.get(h));
        } else {
            int remainingTime = 60 - m;
            int nextTime = h+1;
            if(h == 12)
                nextTime = 1;
            output.append(numbers.get(remainingTime)).append(" ")
                    .append(minutes_unit).append("s").append(" ")
                    .append(prefix).append(" ")
                    .append(numbers.get(nextTime));
        }

        return output.toString();
    }

    private static Map<Integer, String> numberMinutesMapping() {
        Map<Integer, String> numbers = new HashMap<>();
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");
        numbers.put(4, "four");
        numbers.put(5, "five");
        numbers.put(6, "six");
        numbers.put(7, "seven");
        numbers.put(8, "eight");
        numbers.put(9, "nine");
        numbers.put(10, "ten");
        numbers.put(11, "eleven");
        numbers.put(12, "twelve");
        numbers.put(13, "thirteen");
        numbers.put(14, "fourteen");
        numbers.put(16, "sixteen");
        numbers.put(17, "seventeen");
        numbers.put(18, "eighteen");
        numbers.put(19, "nineteen");
        numbers.put(20, "twenty");
        numbers.put(21, "twenty one");
        numbers.put(22, "twenty two");
        numbers.put(23, "twenty three");
        numbers.put(24, "twenty four");
        numbers.put(25, "twenty five");
        numbers.put(26, "twenty six");
        numbers.put(27, "twenty seven");
        numbers.put(28, "twenty eight");
        numbers.put(29, "twenty nine");
        return numbers;
    }

    /**
     * Though it is discussed to be efficient, it misses an edge case of diplaying
     * 13 instead of 1 when the time is 12:50 or any 12ish
     */
    public static String suggestedSolution_convertTimeToWords(int h, int m) {
        String[] arr = {"o' clock","one","two","three","four","five","six",
                "seven","eight","nine","ten","eleven",
                "twelve","thirteen","fourteen","quarter",
                "sixteen","seventeen","eighteen","nineteen",
                "twenty","twenty one","twenty two","twenty three",
                "twenty four","twenty five","twenty six","twenty seven",
                "twenty eight","twenty nine","half"};

        if(m == 0){
            return arr[h] + " " +arr[0];
        }
        else if(m == 15){
            return arr[m]+" past "+ arr[h];
        }
        else if(m == 1){
            return arr[m] +" minute past "+arr[h];
        }
        else if(m < 30){
            return arr[m] +" minutes past "+arr[h];
        }
        else if(m == 30){
            return "half past "+arr[h];
        }
        else if(m == 45){
            return "quarter to "+arr[h+1];
        }
        return arr[60-m] +" minutes to "+arr[h+1];
    }
}
