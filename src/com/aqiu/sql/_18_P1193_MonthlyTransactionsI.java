package com.aqiu.sql;

public class _18_P1193_MonthlyTransactionsI {
    public static void main(String[] args) {
        /*
            select to_char(trans_date, 'yyyy-mm') as month,
                   country,
                   count(*) as trans_count,
                   sum(case when state = 'approved' then 1 else 0 end) as approved_count,
                   sum(amount) as trans_total_amount,
                   sum(case when state = 'approved' then amount else 0 end) as approved_total_amount
            from Transactions
            group by (to_char(trans_date, 'yyyy-mm'), country)
        */
    }
}