package com.gpch.login.model;

import java.awt.geom.Area;

@SuppressWarnings("Duplicates")

public class test {
    public static void main(String[] args) {


        System.out.println(buildSquareWithBackground("#",5));
        System.out.println("");
        System.out.println("");
        System.out.println(buildSquareWithoutBackground("#",10));
        System.out.println("");
        System.out.println("");
        System.out.println(buildSquareWithOneDiagonal("#",10));
        System.out.println("");
        System.out.println("");
        System.out.println(buildSquareWithDiagonals("#",10));
        System.out.println("");
        System.out.println("");
        System.out.println(buildCircle("#",50));


    }


    public static String buildSquareWithBackground(String symnol,Integer size){
        String pattern = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println(pattern);
                pattern += symnol;
            }
            pattern += "\n";
        }
        return pattern;
    }

    public static String buildSquareWithoutBackground(String symnol,Integer size){
        String pattern = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i==0 || i==size-1 || j==0|| j==size-1)
                pattern += symnol;
                else pattern += " ";
            }
            pattern += "\n";
        }
        return pattern;
    }

    public static String buildSquareWithOneDiagonal(String symbol,Integer size){
        String pattern = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1 || i == j)
                    pattern += symbol;
                else pattern += " ";
            }
            pattern += "\n";
        }
        return pattern;
    }

    public static String buildSquareWithDiagonals(String symbol,Integer size){
        String pattern = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1 || i == j || i == size -1 - j )
                    pattern += symbol;
                else pattern += " ";
            }
            pattern += "\n";
        }
        return pattern;
    }

    public static String buildCircle(String symbol, Integer size){
        String pattern = "";
        for (int i = 0; i < size+1; i++) {
            for (int j = 0; j < size+1; j++) {
                double dist = Math.hypot(i-size/2, j-size/2);
                if (dist>size/2-0.5 && dist<size/2 + 0.5) {
                    pattern += symbol;
                } else {
                    pattern += " ";
                }
            }
            pattern += "\n";

        }


        return pattern;
    }

}
