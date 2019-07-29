/* Copyright (c) 2019, Hsin Yu Huang */

package tw.com.pcschool.domain;

/**
 * Author: Hsin Yu Huang<br>
 * Date: 2019年7月22日<br>
 * TODO<br>
 *
 *
 */

public class Student {

	private int stuId;
	private String stuName;
	private int stuAge;
	private String stuPhone;
	private String stuAddress;

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public String getStuPhone() {
		return stuPhone;
	}

	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}

	public String getStuAddress() {
		return stuAddress;
	}

	public void setStuAdress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

}
