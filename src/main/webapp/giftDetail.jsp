<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Детальная страница подарка</title>
</head>
<body>
<h1>Подробности о подарке</h1>
<c:if test="${not empty gift}">
    <p>Название: ${gift.title}</p>
    <p>От кого: ${gift.giverName}</p>
    <p>Кому: ${gift.receiverName}</p>
    <p>Дата доставки: ${gift.deliveryDate}</p>
</c:if>
<c:if test="${empty gift}">
    <p>Подарок не найден</p>
</c:if>
<a href="/">Назад к списку</a>
</body>
</html>