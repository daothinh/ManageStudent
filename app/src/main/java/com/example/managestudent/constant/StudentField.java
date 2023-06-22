package com.example.managestudent.constant;

import android.provider.BaseColumns;

public class StudentField implements BaseColumns {
    public static final String TABLE_NAME = "student";
    public static final String ID_STUDENT = "id_student";
    public static final String NAME = "name";
    public static final String ADDRESS = "address";
    public static final String COURSE_YEAR = "course_year";
    public static final String[] ALL_FIELD = {ID_STUDENT, NAME, ADDRESS, COURSE_YEAR};
}
