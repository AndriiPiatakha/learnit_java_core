package com.itbulls.learnit.javacore.dao.hw.solution.dto.converter;

import com.itbulls.learnit.javacore.dao.hw.solution.dto.RoleDto;

public class RoleDtoToRoleConverter {

	public RoleDto convertRoleNameToRoleDtoWithOnlyRoleName(String roleName) {
		RoleDto roleDto = new RoleDto();
		roleDto.setRoleName(roleName);
		return roleDto;
	}

}
