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
                    <h3>Tabel</h3>

                    <div class="informasi">
                        ini adalah notifikasi pertanda informasi
                    </div>

                    <div class="gagal">
                        ini adalah notifikasi pertanda gagal
                    </div>

                    <div class="sukses">
                        ini adalah notifikasi pertanda sukses
                    </div>
                    <table class="data">
                        <tr class="data">
                            <th class="data" width="30px">No</th>
                            <th class="data">Nama</th>
                            <th class="data">Email</th>
                            <th class="data">Telepon</th>
                            <th class="data" width="75px">Pilihan</th>
                        </tr>
                        <tr class="data">
                            <td class="data" width="30px">16</td>
                            <td class="data">Data Anda</td>
                            <td class="data">Data Anda</td>
                            <td class="data">Data Anda</td>
                            <td class="data" width="75px">
                        <center>
                            <a href="#"><img src="mos-css/img/oke.png"></a>&nbsp;&nbsp;&nbsp;
                            <a href="#"><img src="mos-css/img/detail.png"></a>
                        </center>
                        </td>
                        </tr>
                    </table>
                </div>
                <div class="clear"></div>

            </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
