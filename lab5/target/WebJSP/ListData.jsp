<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.edu.lab5.Book, java.util.*" %>
<table border="1" cellpadding="5">
  <tr>
    <th>Автор</th>
    <th>Название</th>
  </tr>
  <%
    List<Book> books = (List<Book>) request.getAttribute("books");
    if (books != null) {
        for (Book b : books) {
  %>
  <tr>
    <td><%= b.getAuthor() %></td>
    <td><%= b.getTitle() %></td>
  </tr>
  <%
        }
    }
  %>
</table>