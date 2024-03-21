package com.aqiu.sql;

public class _2_P584_FindCustomerReferee {
    public static void main(String[] args) {
        //sql里面的不等于，不包含null
        /*
            select c.name
            from Customer c
            where c.referee_id is null
            or c.referee_id != 2
        */
    }
}