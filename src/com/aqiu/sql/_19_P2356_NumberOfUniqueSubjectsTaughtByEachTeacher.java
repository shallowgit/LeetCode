package com.aqiu.sql;

public class _19_P2356_NumberOfUniqueSubjectsTaughtByEachTeacher {
    public static void main(String[] args) {
        /*
            select teacher_id, count(distinct subject_id) as cnt
            from Teacher
            group by teacher_id
        */
    }
}