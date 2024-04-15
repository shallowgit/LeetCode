package com.aqiu.sql;

public class _30_P1164_ProductPriceAtAGivenDate {
    public static void main(String[] args) {
        /*
            row_number()over(partition by col1 order by col2)表示根据col1分组，在分组内部根据col2排序，而此函数计算的值就表示每组内部排序后的顺序编号（组内连续的唯一的）。
            与rownum的区别在于：使用rownum进行排序的时候是先对结果集加入伪劣rownum然后再进行排序，而row_number()在包含排序从句后是先排序再计算行号码。

            row_number() over (order by col_1[,col_2 ...])
            按照col_1[,col_2 ...]排序,返回排序后的结果集，并且为每一行返回一个不相同的值。

            row_number() over (partition by col_n[,col_m ...] order by col_1[,col_2 ...])
            先按照col_n[,col_m ...进行分组，再在每个分组中按照col_1[,col_2 ...]进行排序(升序)，最后返回排好序后的结果集

            在使用over等开窗函数时，over里头的分组及排序的执行晚于“where，group by，order by”的执行,
            即先执行where子句，执行完后，再给每一条记录进行编号

            常用的分析函数如下所列:
            row_number() over(partition by … order by …)
            rank() over(partition by … order by …)
            dense_rank() over(partition by … order by …)
            count() over(partition by … order by …)
            max() over(partition by … order by …)
            min() over(partition by … order by …)
            sum() over(partition by … order by …)
            avg() over(partition by … order by …)
            first_value() over(partition by … order by …)
            last_value() over(partition by … order by …)
         */
        /*
            select product_id, price
            from
            (
                select product_id,
                       new_price as price,
                       row_number() over (partition by product_id order by change_date desc) as temp
                from Products
                where change_date <= date'2019-08-16'
            )
            where temp = 1
            union
            select product_id, 10 as price
            from Products
            where product_id not in
            (
                select distinct product_id
                from Products
                where change_date <= date'2019-08-16'
            )
        */
    }
}