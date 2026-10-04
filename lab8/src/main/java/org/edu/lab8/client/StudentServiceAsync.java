package org.edu.lab8.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import org.edu.lab8.shared.StudentCourse;
import java.util.List;

/**
 * Асинхронный интерфейс сервиса для работы с данными студентов.
 * GWT автоматически генерирует этот интерфейс для асинхронных вызовов.
 */
public interface StudentServiceAsync {
    void getStudentList(AsyncCallback<List<String>> callback);
    void getStudentCourses(String studentName, AsyncCallback<List<StudentCourse>> callback);
}