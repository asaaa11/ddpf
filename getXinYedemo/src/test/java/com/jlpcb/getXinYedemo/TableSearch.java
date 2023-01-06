package com.jlpcb.getXinYedemo;

public class TableSearch {
    public static void main(String[] args) {
        String[][] table = {
                {"A", "B", "C", "D"},
                {"E", "F", "G", "H"},
                {"I", "J", "K", "L"},
                {"M", "N", "O", "P"}
        };

        // 定义要查找的值
        String searchValue = "F";

        // 横向查找
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (searchValue.equals(table[i][j])) {
                    System.out.println("Found value " + searchValue + " at row " + i + ", column " + j);
                }
            }
        }
    }
}