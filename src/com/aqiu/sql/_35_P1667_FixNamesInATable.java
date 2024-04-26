package com.aqiu.sql;

public class _35_P1667_FixNamesInATable {
    public static void main(String[] args) {
        /*
            substr(string, start, [length])，从start开始，截取 length长度的字符串
            substr(string, start)，从start开始，截取到末尾
            “||” 拼接；
            使用CONCAT进行连接的话，CONCAT(str1, str2)只允许两个参数；换言之，一次只能将两个字串串连起来（如果需要拼接多个字符串，可以进行嵌套）
            小写转大写：upper(str)
            大写转小写：lower(str)
        */
        /*
            select user_id,
                   upper(substr(name, 1, 1)) || lower(substr(name, 2)) as name
            from Users
            order by user_id
        */
    }
}