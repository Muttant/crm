package crm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm.common.Constant;
import crm.service.RoleService;

@WebServlet(name = "roleServlet", urlPatterns = { "/role", "/role/add" })
public class RoleServlet extends HttpServlet {
	private RoleService roleService = new RoleService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String urlPath = req.getServletPath();
		switch (urlPath) {
			case "/role": {
				getAllRoles(req, resp);
			break;
			}
			case "/role/add": {
				addRoles(req, resp);
			break;
			}
		}

	}

	private void getAllRoles(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("roles", roleService.getRole());
		req.getRequestDispatcher("/NewFile.jsp").forward(req, resp);
	}

	private void addRoles(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/NewFile1.jsp").forward(req, resp);
	}
}
//package crm.controller;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import crm.common.Constant;
//import crm.service.RoleService;
//
//@WebServlet(name = "roleServlet", urlPatterns = { "/role"})
//public class RoleServlet extends HttpServlet {
//	private RoleService roleService = new RoleService();
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setAttribute("roles", roleService.getRole());
//		req.getRequestDispatcher("/NewFile.jsp").forward(req, resp);
//
//	}
//}