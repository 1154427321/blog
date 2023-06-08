package fun.luink.blog.system.service.impl;

import fun.luink.blog.common.model.ResultObj;
import fun.luink.blog.model.Role;
import fun.luink.blog.system.repository.RoleRepository;
import fun.luink.blog.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;


    @Override
    public ResultObj addRole(Role role) {
        //添加角色
        Role save = roleRepository.insert(role);
        return ResultObj.success(save);
    }
}
