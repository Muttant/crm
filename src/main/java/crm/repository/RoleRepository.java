package crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm.config.MySQLConnection;
import crm.model.Role;


public class RoleRepository {
	public List<Role> getRole() {
		List<Role> list = new ArrayList<>();
		Connection connection = MySQLConnection.getConnection();
		String query = "select * from roles";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			
			ResultSet resultSet =  preparedStatement.executeQuery();
			while(resultSet.next()) {
				Role role = new Role();
				role.setId(resultSet.getInt("id"));
				role.setRoleName(resultSet.getString("role_name"));
				
				role.setDescription(resultSet.getString("description"));

				list.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection!=null) connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
}
