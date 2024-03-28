package com.aqiu.sql;

public class _20_P1141_UserActivityForThePast30DaysI {
    public static void main(String[] args) {
        /*
            select to_char(activity_date, 'yyyy-mm-dd') as day,
                   count(distinct user_id) as active_users
            from Activity
            where activity_date > date'2019-07-27' - 30
            and activity_date <= date'2019-07-27'
            group by activity_date
        */
    }
}