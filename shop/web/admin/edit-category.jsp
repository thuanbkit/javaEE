<%-- 
    Document   : index
    Created on : Nov 12, 2017, 10:05:44 AM
    Author     : Adminis
--%>

<%@page import="model.Category"%>
<%@page import="dao.CategoryDAO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin MOS Template</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="Copyright" content="arirusmanto.com">
        <meta name="description" content="Admin MOS Template">
        <meta name="keywords" content="Admin Page">
        <meta name="author" content="Ari Rusmanto">
        <meta name="language" content="Bahasa Indonesia">
        <c:set var="root" value="${pageContext.request.contextPath}/admin"/>
        <link href="${root}/mos-css/mos-style.css" rel='stylesheet' type='text/css' />
        <link rel="shortcut icon" href="stylesheet/img/devil-icon.png"> <!--Pemanggilan gambar favicon-->
    </head>

    <body>
        <% 
            String idString = request.getParameter("id");
            Long id = Long.parseLong(idString);
            CategoryDAO categoryDAO = new CategoryDAO();
            Category c =categoryDAO.getItem(id);
        %>
        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include>
                <div id="rightContent">
                    <h3>Sửa danh mục</h3>
                    <form action="/shop/addCategoryServlet?command=edit" method="POST">
                        <table width="95%">
                            <tr>
                                <td width="125px"><b>Tên</b></td>
                                <td><input type="text" name="name" value="<%= c.getName() %>"></td>
                            </tr>
                            <tr><td></td><td>
                                    <input type="hidden" name="id" value="<%= c.getId() %>">
                                    <input type="submit" class="button" value="Submit">
                                    <input type="reset" class="button" value="Reset">
                                </td></tr>
                        </table>
                    </form>
                </div>
                <div class="clear"></div>

            </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
