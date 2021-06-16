package com.uxpsystems.assignment.logger;

import org.apache.log4j.Logger;

public class ServiceLogger {

	private static final Logger LOG = Logger.getLogger(ServiceLogger.class);
	
	private ServiceLogger(){
		
	}

	public static void debug(String referenceNumber, String service, String message) {
		LOG.debug(service + "  :  " + referenceNumber + "  :  " + message);
	}

	public static void info(String referenceNumber, String service, String message) {
		LOG.info(service + "  :  " + referenceNumber + "  :  " + message);
	}

	public static void error(String referenceNumber, String service, String message) {
		LOG.error(service + "  :  " + referenceNumber + "  :  " + message);
	}

	public static void error(String message) {
		LOG.error(message);
	}

	public static void info(String message) {
		LOG.info(message);
	}

	public static void debug(String traceId, String message) {
		LOG.debug(traceId + "  :  " + message);
	}

	public static void info(String traceId, String message) {
		LOG.info(traceId + "  :  " + message);
	}
}
