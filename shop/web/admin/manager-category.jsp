<%-- 
    Document   : index
    Created on : Nov 12, 2017, 10:05:44 AM
    Author     : Adminis
--%>

<%@page import="model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.CategoryDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
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
            CategoryDAO categoryDAO = new CategoryDAO();
            ArrayList<Category> list = categoryDAO.getListCategory();
            int i=1;
        %>
        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include>
                <div id="rightContent">
                    <h3>Danh mục</h3>
                    <p><a href="insert-category.jsp">Thêm mới</a></p>
                    <table class="data">
                        <tr class="data">
                            <th class="data" width="30px">No</th>
                            <th class="data">Tên</th>
                            <th class="data">Danh mục cha</th>
                            <th class="data" width="75px">Tùy chọn</th>
                        </tr>
                        <% for (Category c : list) { %>
                        <tr class="data">
                            <td class="data" width="30px"><%= i %></td>
                            <td class="data"><%= c.getName() %></td>
                            <td class="data">Root</td>
                            <td class="data" width="75px">
                                <center>
                                    <a href="/shop/addCategoryServlet?command=delete&id=<%= c.getId() %>">Xóa</a>&nbsp;&nbsp;&nbsp;
                                    <a href="edit-category.jsp?id=<%= c.getId() %>">Sửa</a>
                                </center>
                            </td>
                        </tr>
                        <% i++;
                            }
                        %>
                    </table>
                </div>
                <div class="clear"></div>

            </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
