package com.shone.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.activation.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.shone.model.Login;
import com.shone.model.Register;

public class UserDaoImpl implements UserDao {
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	public void register(Register user) {
		String sql = "insert into users values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {user.getUsername(),user.getPassword(),user.getFirstname(),user.getLastname(),user.getEmail(),user.getAddress(),user.getPhone()});
	}
	public Register validateUser(Login login) {
	System.out.println(login.getUsername());
	String sql = "select * from users where username='"+login.getUsername()+"' and password='"+login.getPassword()+"'";
	List<Register> user = jdbcTemplate.query(sql, new UserMapper());
	return user.size()>0 ?user.get(0):null;
	
}
class UserMapper implements RowMapper<Register>{
	public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
		Register user = new Register();
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setFirstname(rs.getString("firstname"));
		user.setLastname(rs.getString("lastname"));
		user.setEmail(rs.getString("email"));
		user.setPhone(rs.getString("phone"));
		return user;
	}
}
}
	
	
	

