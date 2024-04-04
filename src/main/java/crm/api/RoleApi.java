package crm.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import crm.common.Constant;
import crm.payload.ResponseData;
import crm.service.RoleService;

@WebServlet(name = "roleApi", urlPatterns = { Constant.URL_ROLE_API_DELETE, Constant.URL_ROLE_API_ADD })
public class RoleApi extends HttpServlet {
	private RoleService roleService = new RoleService();
	private Gson gson = new Gson();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String urlPath = req.getServletPath();
		switch (urlPath) {
		case Constant.URL_ROLE_API_DELETE: {

			deleteRoles(req, resp);
		}
		case Constant.URL_ROLE_API_ADD: {

			addRoles(req, resp);
		}
		}
	}

	private void addRoles(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String roleName = req.getParameter("roleName");
		String desc = req.getParameter("description");
		boolean isSuccess = roleService.insertRole(roleName, desc);
		ResponseData data = new ResponseData();
		data.setSuccess(isSuccess);
		data.setDescription("");
		data.setData("");

		String json = gson.toJson(data);

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.print(json);
		printWriter.flush();
	}

	private void deleteRoles(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		boolean isSuccess = roleService.deleteRoleById(id);
		ResponseData data = new ResponseData();
		data.setSuccess(isSuccess);
		data.setDescription("");
		data.setData("");

		String json = gson.toJson(data);

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.print(json);
		printWriter.flush();

	}

}
