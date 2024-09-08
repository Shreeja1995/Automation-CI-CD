package Udemyacademy.Resources;


	
	import org.testng.annotations.BeforeMethod;


	import org.testng.annotations.Test;

	public class MyClass {

	    // ThreadLocal variable to store data specific to each thread
	    private static ThreadLocal<MyClass> threadLocalData = ThreadLocal.withInitial(() -> new MyClass());

	    // Method to retrieve the ThreadLocal data
	    public static MyClass getThreadLocalData() {
	        return threadLocalData.get();
	    }

	    // This method sets up the thread-local data before each test method
	    @BeforeMethod
	    public void setUp() {
	        // Initialize or set up data as needed
	        MyClass data = new MyClass();
	        threadLocalData.set(data);
	    }

	    // Test method where you use the thread-local data
	    @Test
	    public void myTestMethod() {
	        MyClass data = getThreadLocalData();
	        // Use `data` in your test method
	    }
	}


