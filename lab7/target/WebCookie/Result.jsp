<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.Cookie" %>
<%
    String username = "неизвестно";
    String color = "white";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("username".equals(c.getName())) {
                username = c.getValue();
            }
            if ("color".equals(c.getName())) {
                color = c.getValue();
            }
        }
    }

    Integer count = (Integer) session.getAttribute("count");
    java.util.Date lastVisit = (java.util.Date) session.getAttribute("lastVisit");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Результат</title>
</head>
<body style="background-color: <%= color %>;">
    <h2>Привет, <%= username %>!</h2>
    <p>Цвет страницы: <%= color %></p>
    <p>Количество обращений в сессии: <%= count %></p>
    <p>Дата последнего обращения: <%= lastVisit %></p>
    <br>
    <a href="index.jsp">Вернуться</a>
</body>
</html>