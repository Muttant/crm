package crm.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import crm.payload.ResponseData;
import crm.service.RoleService;

@WebServlet(name = "roleApi", urlPatterns = {"/api/role"})
public class RoleApi extends HttpServlet {
	private RoleService roleService = new RoleService();
	private Gson gson = new Gson(); 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
