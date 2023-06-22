package com.example.managestudent.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.managestudent.constant.CourseField;
import com.example.managestudent.constant.StudentField;
import com.example.managestudent.model.Course;
import com.example.managestudent.model.Student;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "manage_student";
    private static final String TABLE_STUDENT = "student";
    private static final String TABLE_COURSE = "course";
    private static final String TABLE_STUDENT_CLASS = "student_class";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    //Create Table
    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlCreateTableStudent = "CREATE TABLE " + TABLE_STUDENT +
                " (id_student INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "dob TEXT, " +
                "address TEXT, " +
                "course_year INTEGER)";

        String sqlCreateTableCourse = "CREATE TABLE " + TABLE_COURSE +
                " (id_course INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "term INTEGER, " +
                "credit_unit INTEGER, " +
                "description TEXT)";

        String sqlCreateTableStudentClass = "CREATE TABLE " + TABLE_STUDENT_CLASS +
                " (id_student INTEGER, " +
                "id_course INTEGER, " +
                "PRIMARY KEY (id_student, id_course), " +
                "FOREIGN KEY (id_student) REFERENCES student(id_student), " +
                "FOREIGN KEY (id_course) REFERENCES course(id_course))";

        db.execSQL(sqlCreateTableStudent);
        db.execSQL(sqlCreateTableCourse);
        db.execSQL(sqlCreateTableStudentClass);

        Log.d("DB", "onCreate: " + sqlCreateTableStudent);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlDropTableStudent = "DROP TABLE IF EXISTS " + TABLE_STUDENT;
        String sqlDropTableCourse = "DROP TABLE IF EXISTS " + TABLE_COURSE;
        String sqlDropTableStudentClass = "DROP TABLE IF EXISTS " + TABLE_STUDENT_CLASS;

        db.execSQL(sqlDropTableStudent);
        db.execSQL(sqlDropTableCourse);
        db.execSQL(sqlDropTableStudentClass);

        onCreate(db);
    }

    public Boolean addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(StudentField.NAME, student.getName());
        values.put(StudentField.DOB, student.getDob());
        values.put(StudentField.ADDRESS, student.getAddress());
        values.put(StudentField.COURSE_YEAR, student.getCourseYear());

        db.insert(StudentField.TABLE_NAME, null, values);
//        db.close();

        long result = db.insert(StudentField.TABLE_NAME, null, values);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean addCourse(Course course) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(CourseField.NAME, course.getName());
        values.put(CourseField.TERM, course.getTerm());
        values.put(CourseField.CREDIT_UNIT, course.getCreditUnit());
        values.put(CourseField.DESCRIPTION, course.getDescription());
        db.insert(CourseField.TABLE_NAME, null, values);
//        db.close();

        long result = db.insert(CourseField.TABLE_NAME, null, values);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getStudent() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + StudentField.TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }

    public Cursor getCourse() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + CourseField.TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }

    public Cursor getStudentClass(String idCourse) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_STUDENT_CLASS + " WHERE id_course = " + idCourse;
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }

    public Cursor getStudent(String name, String courseYear) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + StudentField.TABLE_NAME + " WHERE name LIKE '%" + name + "%' AND course_year = " + courseYear;
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }

//    SELECT Courses.name,
//    COUNT(Student_Courses.student_id)
//    AS student_count
//    FROM Student_Courses
//    JOIN Courses ON Student_Courses.course_id = Courses.course_id
//    GROUP BY Courses.name
//    ORDER BY student_count DESC;

    public Cursor getStatisticStudentByCourse(String idStudent) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT " + CourseField.NAME + "," +
                " COUNT(" + StudentField.ID_STUDENT + ")" +
                " AS COUNT_STUDENT " +
                " FROM " + TABLE_STUDENT_CLASS +
                " WHERE id_student = " + idStudent;
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }

    public Cursor getStatisticallyStudentClass(String idCourse){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT " + StudentField.COURSE_YEAR + "," +
                " COUNT(" + StudentField.ID_STUDENT + ") AS COUNT_STUDENT " +
                " FROM " + TABLE_STUDENT_CLASS + " WHERE id_course = " + idCourse +
                " GROUP BY " + StudentField.COURSE_YEAR;
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }
}
