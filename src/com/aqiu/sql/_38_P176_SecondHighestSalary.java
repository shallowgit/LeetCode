package com.aqiu.sql;

public class _38_P176_SecondHighestSalary {
    public static void main(String[] args) {
        /*
            确定列中的最大值（最小值）时，MAX( )（MIN( )）函数忽略NULL值。但是，如果在该列中，所有行的值都是NULL，则MAX( )/MIN( )函数将返回NULL值
        */
        /*
            select max(salary) as SecondHighestSalary
            from Employee
            where salary =
            (
                select salary
                from
                (
                    select salary, rownum as rw
                    from
                    (
                        select distinct salary
                        from Employee
                        order by salary desc
                    )
                ) where rw = 2
            )

            select max(salary) as SecondHighestSalary
            from Employee
            where salary < (select max(salary) from Employee)
        */
    }
}