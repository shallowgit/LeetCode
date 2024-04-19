package com.aqiu.sql;

public class _34_P626_ExchangeSeats {
    public static void main(String[] args) {
        /*
            decode(条件,值1,返回值1,值2,返回值2,...值n,返回值n,缺省值)
            lead(field, num, defaultvalue) field需要查找的字段，num往后查找的num行的数据，defaultvalue没有符合条件的默认值
            lag(field, num, defaultvalue)与 lead(field, num, defaultvalue)刚好相反，是往前查找num行的数据
        */
        /*
            select id,
                   decode(mod(id,2), 0, lag(student, 1, student) over (order by id), 1, lead(student, 1, student) over (order by id)) as student
            from Seat
        */
    }
}