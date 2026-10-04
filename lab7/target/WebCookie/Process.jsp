<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.Cookie" %>
<%
    // Кодировка
    request.setCharacterEncoding("UTF-8");

    // Получаем параметры
    String username = request.getParameter("username");
    String color = request.getParameter("color");

    // Сохраняем в Cookie
    Cookie userCookie = new Cookie("username", username);
    userCookie.setMaxAge(60 * 60 * 24);
    response.addCookie(userCookie);

    Cookie colorCookie = new Cookie("color", color);
    colorCookie.setMaxAge(60 * 60 * 24);
    response.addCookie(colorCookie);

    // Работа с сессией
    Integer count = (Integer) session.getAttribute("count");
    if (count == null) {
        count = 1;
    } else {
        count++;
    }
    session.setAttribute("count", count);
    session.setAttribute("lastVisit", new java.util.Date());

    // Перенаправляем БРАУЗЕР на Result.jsp (sendRedirect, не forward!)
    response.sendRedirect("Result.jsp");
%>