package fun.luink.blog.system.service.impl;

import fun.luink.blog.common.model.ResultObj;
import fun.luink.blog.model.Menu;
import fun.luink.blog.system.repository.MenuRepository;
import fun.luink.blog.system.service.MenuService;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {
  @Autowired
  MenuRepository menuRepository;

  @Override
  public ResultObj getMenu(String id) {
    return ResultObj.success(menuRepository.findById(id));
  }

  @Override
  public ResultObj addMenu(Menu menu) {
    Menu save = menuRepository.insert(menu);
    return ResultObj.success(save);
  }

  @Override
  public ResultObj updateMenu(Menu menu) {
    Menu save = menuRepository.save(menu);
    return ResultObj.success(save);
  }

  @Override
  public ResultObj delMenu(List<String> ids) {
    menuRepository.deleteAllById(ids);
    return ResultObj.success();
  }

  @Override
  public ResultObj getMenuList(Menu menu) {
    return ResultObj.success(menuRepository.findAll(Example.of(menu)));
  }
}
