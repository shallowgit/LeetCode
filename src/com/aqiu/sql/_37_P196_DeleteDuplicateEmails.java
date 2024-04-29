package com.aqiu.sql;

public class _37_P196_DeleteDuplicateEmails {
    public static void main(String[] args) {
        /*
            把每个邮箱的最小id查出来，不在这个范围内的id全部删掉
        */
        /*
            delete from Person
            where id not in
            (select min(id) from Person group by email)
        */
    }
}