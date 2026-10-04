package org.edu.lab9;

import static org.mockito.Mockito.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Тестовый класс для сервлета Login.
 * Использует Mockito для создания mock-объектов.
 */
public class LoginServletTest extends TestCase {

    @Mock
    HttpServletRequest request, request1;

    @Mock
    HttpServletResponse response, response1;

    @Mock
    HttpSession session;

    @Mock
    RequestDispatcher rd;

    @Before
    protected void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test() throws Exception {

        // === Тест 1: правильный логин/пароль ===
        when(request.getParameter("user")).thenReturn("12345");
        when(request.getParameter("password")).thenReturn("passw0rd");
        when(request.getSession()).thenReturn(session);

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        when(response.getWriter()).thenReturn(pw);

        Login servlet = new Login();
        servlet.doPost(request, response);

        // Проверки для успешного входа
        verify(session).setAttribute("user", "12345");
        String result = sw.getBuffer().toString().trim();
        assertEquals("Login successful...", result);

        // === Тест 2: неправильный логин/пароль ===
        when(request1.getParameter("user")).thenReturn("wrong");
        when(request1.getParameter("password")).thenReturn("wrong");
        when(request1.getRequestDispatcher("/index.jsp")).thenReturn(rd);

        servlet.doPost(request1, response1);

        // Проверки для неудачного входа
        verify(request1).setAttribute("error", "ERROR");
        verify(rd).forward(request1, response1);
        verify(request1).getRequestDispatcher("/index.jsp");
    }
}