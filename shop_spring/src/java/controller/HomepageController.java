/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import javax.servlet.http.HttpSession;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CategoryService;
import service.ProductService;
import service.UserService;

/**
 *
 * @author Adminis
 */
@Controller
@RequestMapping (value = "/home")
public class HomepageController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @RequestMapping(value = "/index")
    public String index(ModelMap mm) {
        mm.put("list",categoryService.getAllCategory());
        mm.put("products",productService.getProductRandom());
        return "pages/index";
    }
    @RequestMapping(value="/list")
    public String list(ModelMap mm,@RequestParam long catid) {
        mm.put("products",productService.getProductByCategory(catid));
        mm.put("list",categoryService.getAllCategory());
        return "pages/product";
    }
    @RequestMapping(value="/register",method = RequestMethod.GET)
    public String register(ModelMap mm) {
        mm.put("user", new User());
        return "pages/register";
    }
    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String register(@ModelAttribute(value="user") User user,ModelMap mm) {
        userService.insert(user);
        return "pages/register";
    }
    @RequestMapping (value="/login",method = RequestMethod.GET)
    public String login(ModelMap mm) {
        mm.put("tk", new User());
        return "pages/login";
    }
    @RequestMapping (value="/login",method = RequestMethod.POST)
    public String login(@ModelAttribute(value="tk") User tk,ModelMap mm,HttpSession session) {
       mm.put("list",categoryService.getAllCategory());
       User user = userService.login(tk.getEmail(),tk.getPassword());
       if(user != null) {
           session.setAttribute("user",user);
           return "pages/index";
       } else {
           mm.put("msg", "Tai khoan khong hop le");
           return "pages/login";
       }
        
    }
}
