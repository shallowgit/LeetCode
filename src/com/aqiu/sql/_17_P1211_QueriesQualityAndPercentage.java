package com.aqiu.sql;

public class _17_P1211_QueriesQualityAndPercentage {
    public static void main(String[] args) {
        /*
            select query_name,
                   round(sum(rating / position) / count(*), 2) as quality,
                   (round
                       (
                            (sum(case when rating < 3 then 1 else 0 end) / count(*)) * 100, 2
                       )
                   ) as poor_query_percentage
            from Queries
            where query_name is not null
            group by query_name
        */
    }
}