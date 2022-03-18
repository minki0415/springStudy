<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="add"><!-- localhost:8090/add-->
        <label for="">도서명</label><br>
        <input type="text" id="name" name="name"><br>
        <label for="">저자</label><br>
        <input type="text" id="name" name="author"><br><br>
        <button type="submit">보내기</button>
    </form>
</body>
</html>