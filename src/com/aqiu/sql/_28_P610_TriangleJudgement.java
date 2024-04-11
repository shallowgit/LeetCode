package com.aqiu.sql;

public class _28_P610_TriangleJudgement {
    public static void main(String[] args) {
        /*
            select t.*,
                   case when t.x + t.y > t.z
                         and t.x + t.z > t.y
                         and t.y + t.z > t.x
                        then 'Yes'
                   else 'No'
                   end as triangle
            from Triangle t
        */
    }
}