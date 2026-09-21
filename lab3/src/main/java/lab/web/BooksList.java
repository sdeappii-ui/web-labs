package lab.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class BooksList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BooksList() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head><title>Список книг</title></head>");
            out.println("<body>");
            out.println("<h1>Список книг читателя " + (name != null ? name : "без имени") + "</h1>");
            out.println("<table border='1'>");
            out.println("<tr><td><b>Автор книги</b></td><td><b>Название книги</b></td><td><b>Прочитал</b></td></tr>");
            out.println("<tr><td>Булгаков</td><td>Мастер и Маргарита</td><td>Да</td></tr>");
            out.println("<tr><td>Пелевин</td><td>Чапаев и Пустота</td><td>Нет</td></tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}