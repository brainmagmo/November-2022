import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retrier implements IRetryAnalyzer {
  
	static int tries = 0;
	static final int MAX_TRIES = 4;

	@Override
	public boolean retry(ITestResult result) {
		return tries++ < MAX_TRIES;
	}
}
