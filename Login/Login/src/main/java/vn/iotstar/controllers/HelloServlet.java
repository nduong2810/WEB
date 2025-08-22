package vn.iotstar.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/hello", "/xin-chao"})
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String name = "";

        // Nhận cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("username".equals(c.getName())) {
                    name = c.getValue();
                }
            }
        }

        if (name.equals("")) {
            // nếu chưa login thì quay lại Login
            resp.sendRedirect(req.getContextPath() + "/Login.html");
            return;
        }

        // hiển thị lời chào
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Xin chào " + name + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
