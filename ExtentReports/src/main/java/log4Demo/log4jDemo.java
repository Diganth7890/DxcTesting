package log4Demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4jDemo {
	public static Logger log1=LogManager.getLogger(log4jDemo.class.getName());
	public static void main(String[] args) {
		System.out.println("Starting");
		log1.trace("Starting to trace");
		log1.info("Information");
		log1.error("Error");
		log1.warn("Warning");
		log1.fatal("Fatal");
		
	}
}
