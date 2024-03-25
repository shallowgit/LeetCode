package com.aqiu.sql;

public class _9_P197_RisingTemperature {
    public static void main(String[] args) {
        /*
            select w.id
            from Weather w
            inner join Weather temp on temp.recordDate = w.recordDate - 1
            where w.temperature > temp.temperature
        */
    }
}