package com.aqiu.sql;

public class _16_P1633_PercentageOfUsersAttendedAContest {
    public static void main(String[] args) {
        /*
            select r.contest_id, round((count(*) / (select count(*) from Users)) * 100, 2) as percentage
            from Register r
            group by r.contest_id
            order by percentage desc, r.contest_id
        */
    }
}