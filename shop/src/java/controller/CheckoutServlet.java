/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BillDAO;
import dao.BillDetailDAO;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Bill;
import model.BillDetail;
import model.Cart;
import model.Item;
import model.User;
import tool.SendMail;

/**
 *
 * @author Adminis
 */
public class CheckoutServlet extends HttpServlet {
    private final BillDAO billDAO = new BillDAO();
    private final BillDetailDAO billDetailDAO = new BillDetailDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String payment = request.getParameter("payment");
        String address = request.getParameter("address");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user =(User) session.getAttribute("user");
        Bill bill = new Bill();
        long ID = new Date().getTime();
        bill.setId(ID);
        bill.setUser_id(user.getId());
        bill.setTotal(cart.totalCart());
        bill.setPayment(payment);
        bill.setAddress(address);
        bill.setDate(new Timestamp(new Date().getTime()));
        billDAO.insert(bill);
        for (Map.Entry<Long, Item> entry : cart.getCartItems().entrySet()) {
            billDetailDAO.insert(new BillDetail(0,ID,entry.getValue().getProduct().getId(),
            entry.getValue().getProduct().getPrice(),
            entry.getValue().getQuantity()));
        }
        Cart cart2 = new Cart();
        session.setAttribute("cart", cart2);
        SendMail.sendMail(user.getEmail(), "order", "Helll0");
        response.sendRedirect("index.jsp");
        
    }
}
