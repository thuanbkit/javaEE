<%-- 
    Document   : menu
    Created on : Nov 18, 2017, 4:43:35 PM
    Author     : Adminis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="col-sm-3">
            <div class="left-sidebar">

                <div class="brands_products"><!--brands_products-->
                    <h2>Danh mục</h2>
                    <div class="brands-name">
                        <ul class="nav nav-pills nav-stacked">
                            <c:forEach var="item" items="${list}">
                                <li><a href="list?catid=${item.getId()}"> <span class="pull-right">(50)</span>${item.getName()}</a></li>
                            </c:forEach>
                            
                        </ul>
                    </div>
                </div><!--/brands_products-->

                <div class="price-range"><!--price-range-->
                    <h2>Price Range</h2>
                    <div class="well text-center">
                        <input type="text" class="span2" value="" data-slider-min="0" data-slider-max="600" data-slider-step="5" data-slider-value="[250,450]" id="sl2" ><br />
                        <b class="pull-left">$ 0</b> <b class="pull-right">$ 600</b>
                    </div>
                </div><!--/price-range-->

                <div class="shipping text-center"><!--shipping-->
                    <img src="images/home/shipping.jpg" alt="" />
                </div><!--/shipping-->

            </div>
        </div>
    </body>
</html>
