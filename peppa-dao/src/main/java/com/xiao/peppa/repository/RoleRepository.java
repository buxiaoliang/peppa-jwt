package com.xiao.peppa.repository;

import com.xiao.peppa.model.Role;
import com.xiao.peppa.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByName(RoleName name);
}
