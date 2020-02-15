package com.web01.demo.servlet;

import com.web01.demo.UserDaoImpl;
import com.web01.demo.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* @WebServlet注解配置Servlet 示例：
* @WebServlet(name = "myUserServlet",
	urlPatterns = "/user/test",
	loadOnStartup = 1,
	initParams = {
			@WebInitParam(name="name", value="小明"),
			@WebInitParam(name="pwd", value="123456")
	}
)
*/
@WebServlet(name = "LoginServlet", urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //将信息使用 doPost方法执行   对应jsp页面中的form表单中的method
        //doPost(request, response);

        //得到jsp页面传过来的参数
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        UserDao ud = new UserDaoImpl();

        if (ud.login(name, pwd)) {
            request.setAttribute("CrsWeb", "welcome "+name);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("fail.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
