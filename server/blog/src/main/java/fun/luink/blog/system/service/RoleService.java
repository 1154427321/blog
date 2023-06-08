package fun.luink.blog.system.service;

import fun.luink.blog.common.model.ResultObj;
import fun.luink.blog.model.Role;

public interface RoleService {

    /**
     * 添加角色
     * @param role
     * @return
     */
    ResultObj addRole(Role role);


}
