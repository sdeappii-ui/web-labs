package org.edu.lab8.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import org.edu.lab8.shared.StudentCourse;
import java.util.List;

/**
 * Интерфейс удалённого сервиса для работы с данными студентов и их курсов.
 * Использует механизм GWT RPC для взаимодействия клиента и сервера.
 */
@RemoteServiceRelativePath("studentService")
public interface StudentService extends RemoteService {

    /**
     * Возвращает список студентов.
     * @return список имён студентов
     */
    List<String> getStudentList();

    /**
     * Возвращает список курсов выбранного студента.
     * @param studentName имя студента
     * @return список курсов
     */
    List<StudentCourse> getStudentCourses(String studentName);
}