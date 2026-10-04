package org.edu.lab8.shared;

import java.io.Serializable;

/**
 * Класс, представляющий учебный курс студента.
 * Используется для передачи данных между клиентом и сервером через GWT RPC.
 */
public class StudentCourse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String courseName;
    private String teacher;
    private String status;
    private int grade;

    /** Конструктор по умолчанию (обязателен для GWT RPC). */
    public StudentCourse() {}

    /**
     * Конструктор курса.
     * @param courseName название курса
     * @param teacher преподаватель
     * @param status статус ("Завершен" / "В процессе")
     * @param grade оценка (5, 4, 3, 2) или -1, если нет
     */
    public StudentCourse(String courseName, String teacher, String status, int grade) {
        this.courseName = courseName;
        this.teacher = teacher;
        this.status = status;
        this.grade = grade;
    }

    public String getCourseName() { return courseName; }
    public String getTeacher() { return teacher; }
    public String getStatus() { return status; }
    public int getGrade() { return grade; }
}