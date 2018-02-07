/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Item;
import model.Product;

/**
 *
 * @author Adminis
 */
public class CartServlet extends HttpServlet {

    ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String command = request.getParameter("command");
        String product_id = request.getParameter("productID");
        Cart cart = (Cart) session.getAttribute("cart");
       
        try {
            Long id = Long.parseLong(product_id);
            Product product = productDAO.getProductByID(id);
            switch(command) {
                case "plus":
                    if(cart.getCartItems().containsKey(id)) {
                        cart.plusToCart(id, new Item(product,cart.getCartItems().get(id).getQuantity()));
                    } else {
                        cart.plusToCart(id, new Item(product, 1));
                    }
                    break;
                case "remove":
                    cart.removeToCard(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/shop/index.jsp");
        }
        session.setAttribute("cart", cart);
        response.sendRedirect("/shop/index.jsp");
    }

}
