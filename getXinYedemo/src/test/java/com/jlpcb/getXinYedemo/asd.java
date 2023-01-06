package com.jlpcb.getXinYedemo;

import java.util.HashMap;

class TableLookup1 {
    private HashMap<String, HashMap<String, String>> table;

    public TableLookup1() {
        // 初始化表格
        table = new HashMap<>();
        table.put("0.20", new HashMap<>());
        table.put("0.30", new HashMap<>());
        table.put("0.40", new HashMap<>());

        table.get("0.20").put("0.20", "6");
        table.get("0.20").put("0.25", "6");
        table.get("0.20").put("0.275", "7");
        table.get("0.30").put("0.20", "6");
        table.get("0.30").put("0.25", "6");
        table.get("0.40").put("0.20", "5");
        table.get("0.40").put("0.25", "6");
    }

    public String lookup(String row, String col) {
        // 在表格中查找指定的单元格
        return table.get(row).get(col);
    }

    public static void main(String[] args) {
        TableLookup1 table = new TableLookup1();
        String value = table.lookup("0.20", "0.275");
        System.out.println(value); // 输出 "Bear"
    }
}

