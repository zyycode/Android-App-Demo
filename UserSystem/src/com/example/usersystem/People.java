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
		result += "ID��" + this.ID + "��";
		result += "������" + this.Name + "��";
		result += "�Ա�" + this.sex + "�� ";
		result += "���䣺" + this.email + "��";
		result += "�绰��" + this.tell + "��";
		return result;
	}
}
