/* Copyright (c) 2019, Hsin Yu Huang */

package tw.com.pcschool.veiw;

import tw.com.pcschool.domain.Student;
import tw.com.pcschool.factory.StudentDao;
import tw.com.pcschool.impl.StudentImpl;

/**
 * Author: Hsin Yu Huang<br>
 * Date: 2019年7月26日<br>
 * TODO<br>
 *
 *
 */

public class AddMain {

	public static void main(String[] args) {
		//多型
		StudentDao dao= new StudentImpl();
		
		Student s1=new Student();
		
		s1.setStuName("YuYu");
		s1.setStuAge(18);
		s1.setStuPhone("0123-987654");
		s1.setStuAdress("Taipie");
		
		try {
			dao.addStudent(s1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
