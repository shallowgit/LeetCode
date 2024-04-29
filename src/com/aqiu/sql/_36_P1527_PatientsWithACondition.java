package com.aqiu.sql;

public class _36_P1527_PatientsWithACondition {
    public static void main(String[] args) {
        /*
            分两种情况：I型糖尿病写在最前面[以DIAB1开头]和写在中间（前面会有一个空格）[以空格加DIAB1开头]
        */
        /*
            select *
            from Patients
            where instr(conditions, ' DIAB1') > 0
            or instr(conditions, 'DIAB1') = 1

            select *
            from Patients
            where conditions like 'DIAB1%'
               or conditions like '% DIAB1%'
        */
    }
}