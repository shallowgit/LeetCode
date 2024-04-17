package com.aqiu.sql;

public class _32_P1907_CountSalaryCategories {
    public static void main(String[] args) {
        /*
            between and 的左右区间都是闭区间

            union 对两个结果集进行并集操作，会进行去重操作，会按默认规则进行排序
            union all 对两个结果集进行并集操作，不会进行去重操作，不进行排序
            union all 效率要比 union 高，所以在能够确定没有重复记录的情况下, 尽量使用 union all
         */
        /*
            select 'Low Salary' as category, count(*) as accounts_count from Accounts where income < 20000
            union all
            select 'Average Salary' as category, count(*) as accounts_count from Accounts where income between 20000 and 50000
            union all
            select 'High Salary' as category, count(*) as accounts_count from Accounts where income > 50000
        */
    }
}