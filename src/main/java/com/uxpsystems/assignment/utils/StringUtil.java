package com.uxpsystems.assignment.utils;

import org.springframework.stereotype.Component;

@Component
public class StringUtil {

	/* For Checking Null Or Empty */
	public  boolean isNullOrEmpty(String str) {
        if(null !=str  && !str.isEmpty())
            return false;
        return true;
    }
	
	public String isActive(String value){
		if("1".equalsIgnoreCase(value)){
			return ApplicationConstants.Activated;
		}else if("0".equalsIgnoreCase(value)){
			return ApplicationConstants.Deactivated;
		}else if(ApplicationConstants.Activated.equalsIgnoreCase(value)){
			return "1";
		}else if(ApplicationConstants.Deactivated.equalsIgnoreCase(value)){
			return "0";
		}else{
			return value;
		}
	}
	
}
