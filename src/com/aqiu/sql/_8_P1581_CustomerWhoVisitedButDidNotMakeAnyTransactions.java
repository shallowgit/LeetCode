package com.aqiu.sql;

public class _8_P1581_CustomerWhoVisitedButDidNotMakeAnyTransactions {
    public static void main(String[] args) {
        /*
            select v.customer_id, count(*) as count_no_trans
            from Visits v
            where v.visit_id not in
                (
                    select t.visit_id from Transactions t
                )
            group by v.customer_id
        */
    }
}