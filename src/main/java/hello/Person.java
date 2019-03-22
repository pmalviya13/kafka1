package hello;

public class Person {
	private int code;
	private String name;
	private int age;
	private String address;

	Person()
	{
		this.code=0;
		this.name=null;
		this.age=0;
		this.address=null;
	}    
	public void setCode(int code)
	{
		this.code=code;
	}
	public int getCode()
	{
		return this.code;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return this.name;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	public int getAge()
	{
		return this.age;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public String getAddress()
	{
		return this.address;
	}
}