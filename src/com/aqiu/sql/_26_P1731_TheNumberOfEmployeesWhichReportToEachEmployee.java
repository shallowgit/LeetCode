package com.aqiu.sql;

public class _26_P1731_TheNumberOfEmployeesWhichReportToEachEmployee {
    public static void main(String[] args) {
        /*
            select e1.reports_to as employee_id,
                   (select e2.name from Employees e2 where e2.employee_id = e1.reports_to) as name,
                   count(*) as reports_count,
                   round(avg(e1.age)) as average_age
            from Employees e1
            where e1.reports_to is not null
            group by e1.reports_to
            order by e1.reports_to
        */
    }
}