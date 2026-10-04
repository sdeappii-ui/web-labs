package org.edu.lab9;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Сервлет для аутентификации пользователя.
 * Проверяет имя пользователя и пароль, сохраняет данные в Cookie и сессию.
 */
public class Login extends HttpServlet {

    /**
     * Обрабатывает POST-запрос: читает user и password, сравнивает со значениями
     * "12345" и "passw0rd". Если данные верны — создаёт Cookie и выводит
     * "Login successful...". Иначе — перенаправляет на index.jsp с ошибкой.
     *
     * @param req HTTP-запрос с параметрами user и password
     * @param res HTTP-ответ
     * @throws ServletException при ошибке сервлета
     * @throws IOException при ошибке ввода-вывода
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("user");
        String pwd = req.getParameter("password");

        if (name.equals("12345") && pwd.equals("passw0rd")) {
            HttpSession session = req.getSession();
            session.setAttribute("user", name);

            Cookie ck1 = new Cookie("user", name);
            Cookie ck2 = new Cookie("pwd", pwd);
            res.addCookie(ck1);
            res.addCookie(ck2);

            PrintWriter out = res.getWriter();
            out.write("Login successful...");
        } else {
            req.setAttribute("error", "ERROR");
            RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
            rd.forward(req, res);
        }
    }
}