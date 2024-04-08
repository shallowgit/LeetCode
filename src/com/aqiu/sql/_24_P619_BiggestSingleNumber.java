package com.aqiu.sql;

public class _24_P619_BiggestSingleNumber {
    public static void main(String[] args) {
        /*
            select max(num) as num
            from
            (
                select *
                from MyNumbers
                group by num
                having count(*) < 2
            )
        */
    }
}