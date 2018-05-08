package ex3;

public class MyResource implements AutoCloseable {
	byte[] value;

	public MyResource() {
		value = new byte[1000000];
	}

	public void use() {

	}

	@Override
	public void close() throws Exception {
		value = null;
		System.out.println("Resursa eliberata!!!");
	}
}
