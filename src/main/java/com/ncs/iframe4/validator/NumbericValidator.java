package com.ncs.iframe4.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class NumbericValidator implements Validator {
	
	private static final String NUMBERIC_PATTERN = "^\\d*$";
 
	private Pattern pattern;
	private Matcher matcher;
	
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		pattern = Pattern.compile(NUMBERIC_PATTERN);
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
 
			FacesMessage msg = new FacesMessage("Validation failed.", "Invalid format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
 
		}

	}

}
