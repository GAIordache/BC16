package ex2;

/**
 * 
 * Pattern try .. finally for resources
 *
 */
public class Main {

	public static void main(String[] args) {
		MyResource resource = null;
		try {
			resource = new MyResource();
			resource.use();
			methodWithProblems(resource);
		} finally {
			if(resource != null) {
				resource.release();
			}
		}
	}

	static void methodWithProblems(MyResource pResource) {
		if (Math.random() < 0.5) {
			throw new RuntimeException("Aici e buba");
		}
		pResource.use();
	}

}
