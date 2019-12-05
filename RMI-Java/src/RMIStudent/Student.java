package RMIStudent;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
	private int ID;
	private int Age;
	private String Name;
	private float mark;
	public Student()
	{
		this.Age =0;
		this.ID =0;
		this.mark=0;
		this.Name="";
	}
	public Student(int id, String name, int age,float Mark)
	{
		this.ID = id;
		this.Name = name;
		this.Age = age;
		this.mark = Mark;
	}
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}
	public void InputStudent()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("StudentID: ");
		this.ID = sc.nextInt();
		System.out.print("Name: ");
		this.Name = sc.next();
		System.out.print("Age: ");
		this.Age=sc.nextInt();
		System.out.print("Mark: ");
		this.mark = sc.nextFloat();
	}
}
