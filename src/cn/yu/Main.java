package cn.yu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        {
            //graph a
            //initial
            Graph a = new Graph();
            a.neighbours = new HashMap<String, List<String>>();
            {
                a.neighbours.put("1", Arrays.asList("2", "3"));
                a.neighbours.put("2", Arrays.asList("1", "5", "7"));
                a.neighbours.put("3", Arrays.asList("1", "4", "5", "14"));
                a.neighbours.put("4", Arrays.asList("3", "5", "14", "15"));
                a.neighbours.put("5", Arrays.asList("2", "3", "4", "6", "11"));
                a.neighbours.put("6", Arrays.asList("5", "7", "9", "10"));
                a.neighbours.put("7", Arrays.asList("2", "6", "8"));
                a.neighbours.put("8", Arrays.asList("7", "9"));
                a.neighbours.put("9", Arrays.asList("6", "8", "12"));
                a.neighbours.put("10", Arrays.asList("6", "11", "12", "13"));
                a.neighbours.put("11", Arrays.asList("5", "10"));
                a.neighbours.put("12", Arrays.asList("9", "10", "13"));
                a.neighbours.put("13", Arrays.asList("10", "12"));
                a.neighbours.put("14", Arrays.asList("3", "4", "15"));
                a.neighbours.put("15", Arrays.asList("4", "14"));
            }
            //switch loop
            System.out.println("switch loop");
            System.out.println("A)");
            a.switchLoop(Arrays.asList("1", "5", "7", "9"), new BigDecimal(0.1),true);
            System.out.println("B)");
            a.switchLoop(Arrays.asList("1", "5", "7", "9"), new BigDecimal(0.25),true);
            System.out.println("C)");
            a.switchLoop(Arrays.asList("1", "5", "7", "9"), new BigDecimal(0.333333),true);
            System.out.println("D)");
            a.switchLoop(Arrays.asList("2", "13", "15"), new BigDecimal(0.1),true);

            //findM MaxP
            System.out.println("findM MaxP");
            System.out.println("A)");
            System.out.println(a.findMaxP(Arrays.asList("1")));
            System.out.println("B)");
            System.out.println(a.findMaxP(Arrays.asList("5","10","12")));
            System.out.println("C)");
            System.out.println(a.findMaxP(Arrays.asList("7","13","15")));
            System.out.println("D)");
            System.out.println(a.findMaxP(Arrays.asList("4","6","13")));
            System.out.println("E)");
            System.out.println(a.findMaxP(Arrays.asList("3","8","11")));

            //findM verify MaxP
            System.out.println("verify MaxP");
            System.out.println("A)");
            System.out.println(a.switchLoop(Arrays.asList("1"), new BigDecimal(0.3333333334),true));
            System.out.println("B)");
            System.out.println(a.switchLoop(Arrays.asList("5","10","12"), new BigDecimal(0.50001),true));
            System.out.println("C)");
            System.out.println(a.switchLoop(Arrays.asList("7","13","15"), new BigDecimal(0.3333333334),true));
            System.out.println("D)");
            System.out.println(a.switchLoop(Arrays.asList("4","6","13"), new BigDecimal(0.500001),true));
            System.out.println("E)");
            System.out.println(a.switchLoop(Arrays.asList("3","8","11"), new BigDecimal(0.400001),true));
        }
    }
}
