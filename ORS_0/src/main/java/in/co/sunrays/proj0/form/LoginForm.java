package in.co.sunrays.proj0.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Contains Login form elements and their declarative input validations.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 * 
 */
public class LoginForm extends BaseForm{

	/**
	 * email of LoginForm
	 */
	@NotEmpty
	@Email
	/*
	 * @Custom(message = "{Custom.form.emailidd}",regex =
	 * "^[_A-Za-z0-9-]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$")
	 */
	
	private String emailId;
	
	/**
	 * password of LoginForm
	 */
	@NotEmpty
	private String password;
	
	private String uri=null;
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
