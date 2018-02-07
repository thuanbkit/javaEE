<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home | E-Shopper</title>
    </head>

    <body>
        <jsp:include page="header.jsp" ></jsp:include>
        <h2>Đăng ký tài khoản</h2>
        <spring:form method="POST" commandName="user" action="${pageContext.request.contextPath}/home/register" >
            <spring:input path="email"/>
            <spring:password path="password"/>
            <button type="submit" class="btn btn-default">Login</button>
        </spring:form>
        <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
