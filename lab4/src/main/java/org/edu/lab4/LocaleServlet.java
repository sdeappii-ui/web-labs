package org.edu.lab4;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Сервлет с поддержкой интернационализации (русский/английский).
 */
public class LocaleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Чтение параметра lang из строки запроса
        String lang = req.getParameter("lang");

        // Выбор локали
        Locale locale;
        if ("ru".equalsIgnoreCase(lang)) {
            locale = new Locale("ru", "RU");
        } else {
            locale = new Locale("en", "US");
        }

        // Загрузка ресурсов для выбранной локали
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        // Формирование ответа
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>" + bundle.getString("title") + "</title></head>");
        out.println("<body style='font-family:Arial; text-align:center; margin-top:100px;'>");
        out.println("<h1>" + bundle.getString("greeting") + "</h1>");
        out.println("<br>");
        out.println("<a href='?lang=" + ("ru".equals(lang) ? "en" : "ru") + "'>"
                + bundle.getString("language_button") + "</a>");
        out.println("</body></html>");
    }
}