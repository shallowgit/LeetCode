package com.aqiu.sql;

public class _12_P570_ManagersWithAtLeast5DirectReports {
    public static void main(String[] args) {
        //当group by和where一起使用时，where在前，group by在后。
        //即先对select xx from xx的记录集合用where进行筛选，然后再使用group by 对筛选后的结果进行分组
        //而group by和having一起使用时，group by在前，having在后。使用having字句对分组后的结果进行筛选
        //即先对select xx from xx的记录集合用group by进行筛选分组，然后再使用having字句对分组后的结果进行筛选
        /*
            select name
            from Employee
            where id in
            (
                select managerId
                from Employee
                group by managerId
                having count(managerId) > 4
            )
        */
    }
}