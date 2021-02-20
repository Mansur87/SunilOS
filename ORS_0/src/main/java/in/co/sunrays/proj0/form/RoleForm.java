package in.co.sunrays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.RoleDTO;

/**
 * Contains Role form elements and their declarative input validations.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 * 
 */
public class RoleForm extends BaseForm{
	
	/**
	 * rolename of RoleForm
	 */
    @NotEmpty
    @Custom(message = "{Custom.form.RoleName}",regex = "[A-Za-z]+\\.?")
    private String roleName;
    /**
	 * roledescription of RoleForm
	 */
    @NotEmpty
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

    @Override
    public BaseDTO getDto() {

        RoleDTO dto = new RoleDTO();
        dto.setId(id);
        dto.setRoleName(roleName);
        dto.setRoleDescription(roleDescription);
        dto.setCreatedBy(createdBy);
        dto.setModifiedBy(modifiedBy);
        dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
        dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

        return dto;
    }



//bean to view
    @Override
    public void populate(BaseDTO bDto) {

        if (bDto == null) {
            return;
        }

        RoleDTO dto = (RoleDTO) bDto;

        id = dto.getId();
        roleName = dto.getRoleName();
        roleDescription = dto.getRoleDescription();
        createdBy = dto.getCreatedBy();
        modifiedBy = dto.getModifiedBy();
        createdDatetime = dto.getCreatedDatetime().getTime();
        modifiedDatetime = dto.getModifiedDatetime().getTime();
    }

}
