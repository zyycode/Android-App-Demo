package com.example.usersystem;

public class People {

	public int ID = -1;
	public String Name;
	public String sex;
	public String password;
	public String email;
	public String tell;
	
	@Override
	public String toString(){
		String result = "";
		result += "ID：" + this.ID + "，";
		result += "姓名：" + this.Name + "，";
		result += "性别：" + this.sex + "， ";
		result += "邮箱：" + this.email + "，";
		result += "电话：" + this.tell + "，";
		return result;
	}
}
