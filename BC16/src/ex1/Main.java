package ex1;

public class Main {

	public static void main(String[] args) throws MyException {
		try {
			methodWithExceptions();
		} catch(MyException e) {
			e.printStackTrace(System.out);
			e.fillInStackTrace();
			throw e;

		} finally {
			System.out.println("Sunt in finally");
		}
	}
	
	static void methodWithExceptions() throws MyException {
		throw new MyException("mesaj:methodWithExceptions");
	}
	
	static class MyException extends Exception {
		//
		MyException(String pMsg) {
			super(pMsg);
		}
	}

}
