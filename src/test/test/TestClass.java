package test.test;

public class TestClass {
	
	String name;
	
	public String getName(String name) {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TestClass [name=" + name + "]";
	}
	
}
