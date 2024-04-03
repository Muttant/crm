package crm.service;

import java.util.List;

import crm.model.Role;
import crm.repository.RoleRepository;

public class RoleService {
	private RoleRepository roleRepository = new RoleRepository();

	public List<Role> getRole() {
		return roleRepository.getRole();
	}

	public boolean deleteRoleById(int id) {
		return roleRepository.deleteRoleById(id) > 0 ? true : false;
	}
}
