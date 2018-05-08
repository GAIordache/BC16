package ex3;

/**
 * 
 * Pattern try .. finally for resources
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		try (final MyResource resource = new MyResource()) {
			// resource = new MyResource();
			resource.use();
			try {
				methodWithProblems(resource);
			} catch (Ex1 | Ex2 e) {
				e.printStackTrace();
				throw e;

			}
		}
		// finally { resource.close(); }
	}

	static void methodWithProblems(MyResource pResource) throws Ex1, Ex2 {
		if (Math.random() < 0.5) {
			throw new RuntimeException("Aici e buba");
		} else if (Math.random() < 0.8) {
			throw new Ex1();
		} else if (Math.random() < 0.9) {
			throw new Ex2();
		}
		pResource.use();
	}

	static class Ex1 extends Exception {

	}

	static class Ex2 extends Exception {
	}

}
