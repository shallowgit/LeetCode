package com.aqiu.sql;

public class _33_P1978_EmployeesWhoseManagerLeftTheCompany {
    public static void main(String[] args) {
        /*
            select employee_id
            from Employees
            where salary < 30000
            and manager_id is not null
            and manager_id not in (select employee_id from Employees)
            order by employee_id
        */
        /*
            select e1.employee_id
            from Employees e1
            left join Employees e2 on e1.manager_id = e2.employee_id
            where e1.salary < 30000
            and e1.manager_id is not null
            and e2.employee_id is null
            order by e1.employee_id
        */
    }
}