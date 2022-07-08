package com.vrm.main;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

	static Logger logger=Logger.getLogger(Main.class.getClass());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.INFO);
		
		logger.debug("This will not be logged");
		logger.info("This will be logged");
		logger.error("This is an error message");
		logger.fatal("This is an fatal error message");
			
	}

}
