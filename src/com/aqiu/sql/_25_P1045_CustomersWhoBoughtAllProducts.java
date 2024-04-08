package com.aqiu.sql;

public class _25_P1045_CustomersWhoBoughtAllProducts {
    public static void main(String[] args) {
        /*
            select customer_id
            from Customer
            group by customer_id
            having count(distinct product_key) = (select count(*) from Product)
        */
    }
}