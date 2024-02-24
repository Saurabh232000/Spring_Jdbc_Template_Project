package org.jsp.DAO;

import java.util.List;

import org.jsp.DTO.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StudentDao {
	/**
	 * @return the template
	 */
	public JdbcTemplate getTemplate() {
		return template;
	}

	/**
	 * @param template the template to set
	 */
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	private JdbcTemplate template;

	public int saveStudent(Student student) {
		String qry = "insert into student values( ?,?,?,?,?)";
		int save = this.template.update(qry, student.getId(), student.getName(), student.getPhone(), student.getEmail(),
				student.getPassword());
		return save;
	}

	public int updateStudent(Student student) {
		String qry = "update student set name=? ,phone=? ,email=?,password=? where id=?";
		int update = this.template.update(qry, student.getName(), student.getPhone(), student.getEmail(),
				student.getPassword(), student.getId());
		return update;
	}

	public int deleteByStudentId(int id) {
		String qry = "delete from student where id=?";
		int delete = this.template.update(qry, id);
		return delete;
	}

	public List<Student> getStudentById(int id) {
		String qry = "select * from student where id=?";
		RowMapper<Student> rm = new RowMapperImp();
		List<Student> fetch = this.template.query(qry, rm, id);
		return fetch;
	}

	public List<Student> getAllStudent() {
		String qry = "select * from student";
		RowMapper<Student> rm = new RowMapperImp();
		List<Student> Alldata = this.template.query(qry, rm);
		return Alldata;
	}
}
