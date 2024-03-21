package com.aqiu.sql;

public class _5_P1683_InvalidTweets {
    public static void main(String[] args) {
        //处理非 ASCII 字符（比如汉字）时的行为： char_length('刘') = 1(字符)， length('刘') = 3(字节).
        //char_length为mysql语法
        /*
            select t.tweet_id
            from Tweets t
            where length(t.content) > 15
        */
    }
}