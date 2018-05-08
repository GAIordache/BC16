package ex2;

public class MyResource {
	byte[] value;
	
	public MyResource() {
		value = new byte[1000000];
	}
	
	public void use() {
		
	}
	
	public void release() {
		value = null;
		System.out.println("Resursa eliberata!!!");
	}
}
