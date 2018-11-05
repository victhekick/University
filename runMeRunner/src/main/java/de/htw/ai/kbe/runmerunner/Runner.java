package de.htw.ai.kbe.runmerunner;

public class Runner {
	
	@RunMe
	void method1() {
		System.out.println("In method1() of FooKind");
	}

    @RunMe
    int methodInt() {
        System.out.println("In methodInt() of FooKind");
        return 0;
    }
    
	void testMethod() {
		System.out.println("In testMethod() of FooKind");
	}
	
	void testMethod2(String str) {
		System.out.println("In testMethod2(str) of FooKind");
	}
	
	String testMethod3() {
        System.out.println("In testMethod3() of FooKind");
        return "";
    }

}
