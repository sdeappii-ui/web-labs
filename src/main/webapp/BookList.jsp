<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.edu.lab5.Book, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Список книг</title>
</head>
<body>
<%
  request.setCharacterEncoding("UTF-8");
  String name = request.getParameter("name");
  if (name == null || name.isEmpty()) {
      RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/ErrorManager.jsp");
      dispatcher.forward(request, response);
      return;
  }
  List<Book> books = new ArrayList<>();
  books.add(new Book("Булгаков", "Мастер и Маргарита"));
  books.add(new Book("Достоевский", "Преступление и наказание"));
  books.add(new Book("Толстой", "Война и мир"));
  request.setAttribute("books", books);
%>
<h2>Список книг читателя <%= name %></h2>
<jsp:include page="ListData.jsp"/>
</body>
</html>