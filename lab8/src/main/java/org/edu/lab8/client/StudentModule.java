package org.edu.lab8.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import org.edu.lab8.shared.StudentCourse;
import java.util.List;

/**
 * Главный модуль GWT-приложения для управления учебными курсами студентов.
 * Точка входа — метод onModuleLoad().
 */
public class StudentModule implements EntryPoint {

    private final StudentServiceAsync studentService = GWT.create(StudentService.class);
    private final ListBox studentListBox = new ListBox();
    private final FlexTable coursesTable = new FlexTable();

    @Override
    public void onModuleLoad() {
        // Заголовки
        RootPanel.get().add(new HTML("<h2>Учебные курсы студентов</h2>"));
        RootPanel.get().add(new HTML("<h3>Система управления учебными курсами студентов</h3>"));

        // Панель выбора студента
        HorizontalPanel selectPanel = new HorizontalPanel();
        selectPanel.setSpacing(5);
        selectPanel.add(new Label("Выберите студента:"));
        selectPanel.add(studentListBox);
        Button showButton = new Button("Показать курсы");
        selectPanel.add(showButton);
        RootPanel.get().add(selectPanel);

        // Таблица
        coursesTable.setText(0, 0, "Название курса");
        coursesTable.setText(0, 1, "Преподаватель");
        coursesTable.setText(0, 2, "Статус");
        coursesTable.setText(0, 3, "Оценка");
        coursesTable.getRowFormatter().addStyleName(0, "headerRow");
        coursesTable.setCellPadding(5);
        coursesTable.setBorderWidth(1);
        coursesTable.setStyleName("coursesTable");
        RootPanel.get().add(coursesTable);

        // Загрузка списка студентов
        studentService.getStudentList(new AsyncCallback<List<String>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Ошибка загрузки: " + caught.getMessage());
            }
            @Override
            public void onSuccess(List<String> result) {
                for (String s : result) {
                    studentListBox.addItem(s);
                }
            }
        });

        // Обработчик кнопки
        showButton.addClickHandler(event -> {
            String selected = studentListBox.getSelectedValue();
            if (selected == null) {
                Window.alert("Выберите студента");
                return;
            }

            studentService.getStudentCourses(selected, new AsyncCallback<List<StudentCourse>>() {
                @Override
                public void onFailure(Throwable caught) {
                    Window.alert("Ошибка: " + caught.getMessage());
                }
                @Override
                public void onSuccess(List<StudentCourse> result) {
                    for (int i = coursesTable.getRowCount() - 1; i > 0; i--) {
                        coursesTable.removeRow(i);
                    }
                    for (int i = 0; i < result.size(); i++) {
                        StudentCourse c = result.get(i);
                        coursesTable.setText(i + 1, 0, c.getCourseName());
                        coursesTable.setText(i + 1, 1, c.getTeacher());
                        coursesTable.setText(i + 1, 2, c.getStatus());
                        coursesTable.setText(i + 1, 3,
                            c.getGrade() > 0 ? String.valueOf(c.getGrade()) : "-");
                    }
                }
            });
        });
    }
}