package junit_projects;

import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

//@RunWith(Suite.class)
//@SuiteClasses({ simple_projects.class, A.class, B.class })
public class Runner_class {
	@Test
	public void TC() {
		Result RC = JUnitCore.runClasses(B.class,A.class,simple_projects.class);
		System.out.println("TOTAL RUN COUNT = "+ RC.getRunCount());
		System.out.println("TOTAL RUN TIME = "+ RC.getRunTime());
		System.out.println("TOTAL FAIL COUNT = "+ RC.getFailureCount());  
		System.out.println("TOTAL TEST CASE IGNORED COUNT = "+RC.getIgnoreCount());
	List<Failure> f = RC.getFailures();
	for (Failure fail : f) {
		System.out.println(fail);
	}
	
	}
}
