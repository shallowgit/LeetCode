package com.aqiu.sql;

public class _31_P1204_LastPersonToFitInTheBus {
    public static void main(String[] args) {
        /*
            参考文章链接：https://www.cnblogs.com/luhe/p/4155612.html
            sum(...) over( )，对所有行求和
            sum(...) over( order by ... )，第一行 到 与当前行同序号行的最后一行的所有值求和
            Oracle中的rownum的是在取数据的时候产生的序号
         */
        /*
            select person_name
            from
            (
                select person_name,
                       sum(weight) over(order by turn) as totalWeight
                from Queue
                order by turn desc
            )
            where totalWeight <= 1000
            and rownum = 1
        */
    }
}