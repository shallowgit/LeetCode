package com.aqiu.sql;

public class _13_P620_NotBoringMovies {
    public static void main(String[] args) {
        //mod(a,b) 在sql中的意思是 a / b 的余数
        //mod(id, 2)=1 是指id是奇数。
        //mod(id, 2)=0 是指id是偶数。
        /*
            select *
            from Cinema
            where mod(id, 2) = 1
            and description != 'boring'
            order by rating desc
        */
    }
}