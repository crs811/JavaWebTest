package com.web01.demo.servlet;

import com.web01.demo.UserDaoImpl;
import com.web01.demo.dao.UserDao;
import com.web01.demo.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CRS
 */
@WebServlet(name = "RegisterServlet", urlPatterns = "/Register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //doPost(request, response);
        //获取jsp页面传过来的参数
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        String home = request.getParameter("home");
        String info = request.getParameter("info");

        //实例化一个对象，组装属性
        User user = new User();
        user.setName(name);
        user.setPwd(pwd);
        user.setSex(sex);
        user.setHome(home);
        user.setInfo(info);

        UserDao ud = new UserDaoImpl();

        if(ud.register(user)){
            //向request域中放置参数
            request.setAttribute("username", name);
            //request.setAttribute("xiaoxi", "注册成功");
            //转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else{
            //重定向到首页
            response.sendRedirect("index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
