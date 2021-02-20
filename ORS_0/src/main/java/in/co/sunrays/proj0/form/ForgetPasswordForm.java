package in.co.sunrays.proj0.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Contains Forget Password form elements and their declarative input validations.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public class ForgetPasswordForm extends BaseForm{
	
	/**
	 * email of FrogetPassword
	 *
	 */   
	@NotEmpty
    @Email
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
