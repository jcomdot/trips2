package com.jcomdot.trips;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(
		name = "HelloWorldServlet",
		urlPatterns = {"/hello.html"},
		initParams = {
				@WebInitParam(name="msg1", value="ようこそ～ジャバの世界へ！")
		}
)
public class HelloWorldServlet extends HttpServlet {
	
	private static final long serialVersionUID = -2079747187918334362L;
	private String message;

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.message = config.getInitParameter("msg1");
		getServletContext().setAttribute("mypet", "tobbung2");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        Date date = Calendar.getInstance().getTime();
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
        out.println("<title>현재 시각2</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>오늘은 " + date + "입니다.</h1>");
        out.println("<p>info: " + this.getServletConfig().getServletName() + "</p>");
        out.println("<p>msg1: " + this.message + "</p>");
        String msg = req.getParameter("msg");
        if (msg != null) {
        	out.println("<p>msg: " + req.getParameter("msg") + "</p>");
        }
        out.println(getServletContext().getAttribute("mypet"));
        out.println("</body>");
        out.println("</html>");
        out.close();
	}

}
