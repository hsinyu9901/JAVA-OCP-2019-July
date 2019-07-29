/* Copyright (c) 2019, Hsin Yu Huang */

package tw.com.pcschool.factory;

import java.sql.ResultSet;

import tw.com.pcschool.domain.Student;

/**
 * Author: Hsin Yu Huang<br>
 * Date: 2019年7月26日<br>
 * TODO<br>
 *
 *
 */

public interface StudentDao {

	/*
	 * private int stuId;
	private String stuName;
	private int stuAge;
	private String stuPhone;
	private String stuAddress;
	 */
	
	public void addStudent(Student stu) throws Exception;
	
	public ResultSet selectAllStudent() throws Exception;
	
	public ResultSet oneSelect(String name) throws Exception;
	
/*	
	public Student findStudentId(int stuId);
	
	public List<Student> findStudentName(String stuName);
	
	public List<Student> findStudentAge(int stuAge);
	
	public Student findStudentphone(String stuPhone);
	
	public List<Student> findStudentAddress(String stuAddress);
	
	public List<Student> updateStudent(Student stu);
	
	public void deleteStudent(Student stu);
	*/
}
