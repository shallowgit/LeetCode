package com.aqiu.sql;

public class _14_P1934_ConfirmationRate {
    public static void main(String[] args) {
        /*
            select s.user_id,
            (
               round(
                        sum(
                                case when c.action = 'confirmed' then 1
                                else 0
                                end
                           ) / count(*), 2
                    )
            ) confirmation_rate
            from Signups s
            left join Confirmations c on c.user_id = s.user_id
            group by s.user_id
        */
    }
}