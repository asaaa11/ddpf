package com.jlpcb.getXinYedemo;

import java.util.HashMap;
import java.util.Map;

public class TableLookup {
    private Map<String, Map<String, String>> table;

    public TableLookup() {
        // 初始化表格，这里假设表格有两行两列
        table = new HashMap<>();
        Map<String, String> row1 = new HashMap<>();
        row1.put("0.20", "6");
        row1.put("0.25", "6");
        table.put("0.20", row1);
        Map<String, String> row2 = new HashMap<>();
        row2.put("0.275", "7");
        row2.put("0.30", "8");
        table.put("0.30", row2);
    }

    public String lookup(String row, String col) {
        // 检查表格中是否存在给定的行和列
        if (table.containsKey(row) && table.get(row).containsKey(col)) {
            return table.get(row).get(col);
        }
        return null;
    }

    public static void main(String[] args) {
        TableLookup1 table = new TableLookup1();
        String value = table.lookup("0.275", "0.20");
        System.out.println(value); // 输出 value1
    }
}
