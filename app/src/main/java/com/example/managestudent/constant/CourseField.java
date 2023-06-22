package com.example.managestudent.constant;

import android.provider.BaseColumns;

public class CourseField implements BaseColumns {
    public static final String TABLE_NAME = "course";
    public static final String ID_COURSE = "id_course";
    public static final String NAME = "name";

    public static final String TERM = "term";
    public static final String CREDIT_UNIT = "credit_unit";
    public static final String DESCRIPTION = "description";

    public static final String[] ALL_FIELD = {ID_COURSE, NAME, TERM, CREDIT_UNIT, DESCRIPTION};
}
