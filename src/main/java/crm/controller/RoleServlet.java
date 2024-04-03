package crm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm.service.RoleService;

@WebServlet(name = "roleServlet", urlPatterns = {"/role"})
public class RoleServlet extends HttpServlet{
	private RoleService roleService = new RoleService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("roles", roleService.getRole());
		
		req.getRequestDispatcher("/NewFile.jsp").forward(req, resp);
	}
}
