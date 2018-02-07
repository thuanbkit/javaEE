/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import tool.MD5;

/**
 *
 * @author Adminis
 */
public class UserServlet extends HttpServlet {

    private final UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        User user = new User();
        HttpSession session = request.getSession();
        String url;
        switch (command) {
            case "register":
                user.setId(0);
                user.setEmail(request.getParameter("email"));
                user.setPassword(MD5.encryption(request.getParameter("password")));
                user.setRole(true);
                userDAO.insert(user);
                session.setAttribute("user", user);
                url = "/index.jsp";
                break;
            case "login":
                
                user = userDAO.login(request.getParameter("email"),MD5.encryption(request.getParameter("password")));
                if(user != null) {
                    session.setAttribute("user", user);
                    url = "/index.jsp";
                } else {
                  url = "/login.jsp";  
                }
                break;
        }

        
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);

    }
}
