<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Введите данные</title>
</head>
<body>
    <h2>Введите имя и цвет страницы:</h2>
    <form action="Process.jsp" method="post">
        Имя: <input type="text" name="username" required><br><br>
        Цвет: <select name="color">
            <option value="lightblue">Голубой</option>
            <option value="lightgreen">Зелёный</option>
            <option value="lightyellow">Жёлтый</option>
            <option value="pink">Розовый</option>
        </select><br><br>
        <input type="submit" value="Отправить">
    </form>
</body>
</html>