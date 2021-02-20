package in.co.sunrays.proj0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Role POJO class. It is persistent object.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 *
 */
@Entity
@Table(name="ST_ROLE")
public class RoleDTO extends BaseDTO{

	public static final Long ADMIN = 1L;
    public static final Long STUDENT = 2L;
    public static final Long COLLEGE = 3L;
    
    /**
     * Name of Role
     */
    @Column(name="NAME", length=50)
    private String roleName;
    
    /**
     * Description of Role
     */
    @Column(name="DESCRIPTION", length=70)
    private String roleDescription;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return roleName;
	}
    
    
    
}
