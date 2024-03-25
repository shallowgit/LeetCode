package com.aqiu.sql;

public class _11_P1280_StudentsAndExaminations {
    public static void main(String[] args) {
        /*
            select stu.student_id,
                   stu.student_name,
                   sub.subject_name,
                   (
                       select count(*)
                       from examinations e
                       where e.student_id = stu.student_id
                       and e.subject_name = sub.subject_name
                   ) attended_exams
            from students stu, subjects sub
            order by stu.student_id, sub.subject_name
        */
    }
}