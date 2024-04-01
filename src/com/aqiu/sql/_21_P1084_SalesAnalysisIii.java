package com.aqiu.sql;

public class _21_P1084_SalesAnalysisIii {
    public static void main(String[] args) {
        /*
            select p.product_id, p.product_name
            from Product p
            where p.product_id in
            (
                select distinct s.product_id
                from Sales s
                where s.product_id not in
                      (
                          select distinct ss.product_id
                          from Sales ss
                          where ss.sale_date < date'2019-01-01'
                             or ss.sale_date > date'2019-03-31'
                      )
            )
        */
    }
}