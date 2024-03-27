package com.aqiu.sql;

public class _15_P1075_ProjectEmployeesI {
    public static void main(String[] args) {
        //见 https://blog.csdn.net/ahwsk/article/details/82886732
        /*
            select p.project_id, round(sum(e.experience_years) / count(p.employee_id), 2) as average_years
            from Project p
            inner join Employee e on p.employee_id = e.employee_id and e.experience_years is not null
            group by p.project_id
        */
    }
}