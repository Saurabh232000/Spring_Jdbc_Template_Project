package org.jsp.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jsp.DTO.Student;
import org.springframework.jdbc.core.RowMapper;

public class RowMapperImp implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student s = new Student();
		s.setId(rs.getInt(1));
		s.setName(rs.getString(2));
		s.setPhone(rs.getLong(3));
		s.setEmail(rs.getString(4));
		s.setPassword(rs.getString(5));
		return s;
	}

}
