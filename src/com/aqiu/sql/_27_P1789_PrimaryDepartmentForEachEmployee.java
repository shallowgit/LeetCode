package com.aqiu.sql;

public class _27_P1789_PrimaryDepartmentForEachEmployee {
    public static void main(String[] args) {
        /*
            select e.employee_id, sum(e.department_id) as department_id
            from Employee e
            group by e.employee_id
            having count(*) = 1
            union
            select e.employee_id, e.department_id
            from Employee e
            where e.primary_flag = 'Y'
        */
    }
}