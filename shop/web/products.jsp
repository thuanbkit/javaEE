<%-- 
    Document   : index
    Created on : Oct 31, 2017, 9:56:55 PM
    Author     : Adminis
--%>

<%@page import="model.Cart"%>
<%@page import="model.Product"%>
<%@page import="dao.ProductDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>shop</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Bonfire Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
<!--//fonts-->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
				<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
				</script>
<!--slider-script-->
		<script src="js/responsiveslides.min.js"></script>
			<script>
				$(function () {
				  $("#slider1").responsiveSlides({
					auto: true,
					speed: 500,
					namespace: "callbacks",
					pager: true,
				  });
				});
			</script>
<!--//slider-script-->
<script>$(document).ready(function(c) {
	$('.alert-close').on('click', function(c){
		$('.message').fadeOut('slow', function(c){
	  		$('.message').remove();
		});
	});	  
});
</script>
<script>$(document).ready(function(c) {
	$('.alert-close1').on('click', function(c){
		$('.message1').fadeOut('slow', function(c){
	  		$('.message1').remove();
		});
	});	  
});
</script>
</head>
    <body>
        <%
            long catid = Long.parseLong(request.getParameter("catid"));
            long pages = 1, start =0,limit = 8;
            if(request.getParameter("pages") != null) {
                pages = Long.parseLong(request.getParameter("pages"));
            }
            ProductDAO dao = new ProductDAO();
            long total = dao.coutProductByCategory(catid);
            if(total > 8) {
                start = (pages-1)* limit;
            }
            Cart cart = (Cart) session.getAttribute("cart");
            if(cart == null ) {
                cart = new Cart();
                session.setAttribute("cart",cart);
            }
        %>
        <jsp:include page="header.jsp"></jsp:include>
        <jsp:include page="banner.jsp"></jsp:include>
		<div class="container">
			<div class="products">
					<h2 class=" products-in">PRODUCTS</h2>
					<div class=" top-products">
                                        <%
                                            
                                            for(Product p: dao.getListProductByCategory(catid,start,limit)) {
                                                
                                            
                                        %>
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href="single.html" class="compare-in"><img  src="<%= p.getImage() %>" alt="avd" />
								<div class="compare">
									<span>Add to Compare</span>
									<span>Add to Whislist</span>
								</div>
								</a>	
								<div class="top-content">
									<h5><a href="single.html"><%= p.getName() %></a></h5>
									<div class="white">
										<a href="CartServlet?command=plus&productID=<%= p.getId() %>" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD TO CART</a>
										<p class="dollar"><span class="in-dollar">$</span><span>2</span><span>0</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
                                                <% } %>
                                              
					<div class="clearfix"></div>
					</div>
			</div>
		</div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
