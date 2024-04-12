package com.aqiu.sql;

public class _29_P180_ConsecutiveNumbers {
    public static void main(String[] args) {
        /*
            INNER JOIN：内连接，也可以只写JOIN。只有进行连接的两个表中，都存在与连接标准相匹配的数据才会被保留下来，相当于两个表的交集。如果前后连接同一张表，也叫自连接。
            LEFT JOIN: 左连接，也称左外连接。操作符左边表中符合 WHERE 子句的所有记录将会被返回，操作符右边表中如果没有符合 ON 后面连接条件的记录时，那么从右边表指定选择的列的值将会是 NULL。
            RIGHT JOIN: 右连接，也称右外连接。会返回右边表所有符合 WHERE 语句的记录。左表中匹配不上的宇段值用 NULL 代替。
            FULL JOIN：全连接，返回所有表中符合 WHERE 语句条件的所有记录。如果任一表的指定宇段没有符合条件的值的话，那么就使用 NULL 替代。
        */
        /*
            select distinct l.num as ConsecutiveNums
            from Logs l
            join Logs l2 on l.num = l2.num and l2.id = l.id + 1
            join Logs l3 on l.num = l3.num and l3.id = l2.id + 1
        */
    }
}