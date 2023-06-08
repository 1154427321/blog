package fun.luink.blog.system.controller;

import fun.luink.blog.common.model.ResultObj;
import fun.luink.blog.model.Role;
import fun.luink.blog.system.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {


    @Autowired
    RoleService roleService;

    /**
     * 账号登录接口
     * @return
     */
    @PostMapping("/getRoles")
    @Operation(summary = "获取角色列表",description = "获取角色列表")
    public ResultObj accountLogin(){

        return ResultObj.success("reoreo");
    }

    /**
     * 账号登录接口
     * @return
     */
    @PostMapping("/addRole")
    public ResultObj accountLogin(@RequestBody Role role){
        //添加角色
        return roleService.addRole(role);
    }
}
