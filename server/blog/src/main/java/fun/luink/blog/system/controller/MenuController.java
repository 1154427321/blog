package fun.luink.blog.system.controller;

import fun.luink.blog.common.model.R;
import fun.luink.blog.model.Menu;
import fun.luink.blog.system.service.MenuService;
import java.lang.String;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
@Tag(name = "菜单管理", description = "菜单管理")
public class MenuController {
  @Autowired
  MenuService menuService;

  @GetMapping("/getMenu/{id}")
  @Operation(summary = "获取菜单", description = "获取菜单")
  public R getMenu(@PathVariable("id") String id) {
    return menuService.getMenu(id);
  }

  @PutMapping("/addMenu")
  @Operation(summary = "添加菜单", description = "添加菜单")
  public R addMenu(Menu menu) {
    return menuService.addMenu(menu);
  }

  @PutMapping("/updateMenu")
  @Operation(summary = "更新菜单", description = "更新菜单")
  public R updateMenu(Menu menu) {
    return menuService.updateMenu(menu);
  }

  @DeleteMapping("/delMenu")
  @Operation(summary = "删除菜单", description = "删除菜单")
  public R delMenu(List<String> menu) {
    return menuService.delMenu(menu);
  }

  @PostMapping("/getMenuList")
  @Operation(summary = "获取菜单列表", description = "获取菜单列表")
  public R getMenuList(Menu menu) {
    return menuService.getMenuList(menu);
  }
}
