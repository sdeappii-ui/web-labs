package org.edu.lab8.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.edu.lab8.client.StudentService;
import org.edu.lab8.shared.StudentCourse;
import java.util.*;

/**
 * Реализация сервиса для работы с данными студентов и их курсов.
 * Хранит тестовые данные в HashMap.
 */
public class StudentServiceImpl extends RemoteServiceServlet implements StudentService {

    private Map<String, List<StudentCourse>> db = new HashMap<>();

    /** Конструктор — инициализирует тестовые данные. */
    public StudentServiceImpl() {
        List<StudentCourse> courses1 = new ArrayList<>();
        courses1.add(new StudentCourse("Web-программирование", "Проф. Петров", "Завершен", 5));
        courses1.add(new StudentCourse("Базы данных", "Доц. Сидорова", "Завершен", 4));
        courses1.add(new StudentCourse("Машинное обучение", "Проф. Козлов", "В процессе", -1));
        db.put("Иванов Алексей", courses1);

        List<StudentCourse> courses2 = new ArrayList<>();
        courses2.add(new StudentCourse("Web-программирование", "Проф. Петров", "Завершен", 4));
        courses2.add(new StudentCourse("Алгоритмы", "Доц. Смирнов", "Завершен", 5));
        db.put("Петрова Мария", courses2);
    }

    @Override
    public List<String> getStudentList() {
        return new ArrayList<>(db.keySet());
    }

    @Override
    public List<StudentCourse> getStudentCourses(String studentName) {
        return db.getOrDefault(studentName, new ArrayList<>());
    }
}