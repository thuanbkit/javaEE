<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <jsp:include page="slider.jsp"></jsp:include>
        <section>
            <div class="container">
                <div class="row">
                    <jsp:include page="menu.jsp"></jsp:include>
                    <jsp:include page="content.jsp"></jsp:include>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
