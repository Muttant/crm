package crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import crm.config.MySQLConnection;
import crm.model.User;

public class UserRepository {
	public List<User> getUserByUsernameAndPassword(String username, String password) {
		List<User> list = new ArrayList<>();
		Connection connection = MySQLConnection.getConnection();
		String query = "select * from users u where u.username = ? and u.password = ? ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet =  preparedStatement.executeQuery();
			while(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setFullname(resultSet.getString("fullname"));
				user.setAge(resultSet.getInt("age"));
				user.setUsername(resultSet.getString("username"));

				list.add(user);
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
