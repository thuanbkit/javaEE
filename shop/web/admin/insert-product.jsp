<%-- 
    Document   : index
    Created on : Nov 12, 2017, 10:05:44 AM
    Author     : Adminis
--%>

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
        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include>
                <div id="rightContent">
                    <h3>Form</h3>

                    <div class="informasi">
                        ini adalah notifikasi pertanda informasi
                    </div>

                    <div class="gagal">
                        ini adalah notifikasi pertanda gagal
                    </div>

                    <div class="sukses">
                        ini adalah notifikasi pertanda sukses
                    </div>

                    <table width="95%">
                        <tr><td width="125px"><b>Input text pendek</b></td><td><input type="text" class="pendek"></td></tr>
                        <tr><td><b>Input text sedang</b></td><td><input type="text" class="sedang"></td></tr>
                        <tr><td><b>Input text panjang</b></td><td><input type="text" class="panjang"></td></tr>
                        <tr><td><b>Radio</b></td><td>
                                <input type="radio" name="radio" id="radio" value="radio 1">Radio 1
                                <input type="radio" name="radio" id="radio" value="radio 2">Radio 2
                            </td></tr>
                        <tr><td><b>Checkbox</b></td><td>
                                <input type="checkbox" name="checkbox" id="checkbox" value="checkbox 1">Checkbox 1<br>
                                <input type="checkbox" name="checkbox" id="checkbox" value="checkbox 2">Checkbox 2<br>
                                <input type="checkbox" name="checkbox" id="checkbox" value="checkbox 3">Checkbox 3<br>
                                <input type="checkbox" name="checkbox" id="checkbox" value="checkbox 4">Checkbox 4<br>
                            </td></tr>
                        <tr><td><b>Pilihan</b></td><td>
                                <select>
                                    <option selected>-- pilihan --</option>
                                    <option value="">Pilihan</option>
                                </select>
                            </td></tr>
                        <tr><td><b>Textarea</b></td><td><textarea></textarea></td></tr>
                        <tr><td></td><td>
                                <input type="button" class="button" value="Button">
                                <input type="submit" class="button" value="Submit">
                                <input type="reset" class="button" value="Reset">
                            </td></tr>
                    </table>
                </div>
                <div class="clear"></div>

            </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
