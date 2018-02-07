/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;

/**
 *
 * @author Adminis
 */
public class addCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idString = request.getParameter("id");
        long id = Long.parseLong(idString);
        Category category = new Category();
        CategoryDAO categoryDAO = new CategoryDAO();
        category.setId(id);
        categoryDAO.destroy(category);
        response.sendRedirect("admin/manager-category.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String command = request.getParameter("command");
        String name = request.getParameter("name");
        Category category = new Category();
        category.setName(name);

        CategoryDAO categoryDAO = new CategoryDAO();
        switch (command) {
            case "add":
                categoryDAO.insert(category);
                break;
            case "edit":
                String idString = request.getParameter("id");
                long id = Long.parseLong(idString);
                category.setId(id);
                categoryDAO.update(category);
                break;

        }

        response.sendRedirect("admin/manager-category.jsp");
    }

}
