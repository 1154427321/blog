package fun.luink.blog.system.service.impl;

import fun.luink.blog.common.model.R;
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
  public R getMenu(String id) {
    return R.success(menuRepository.findById(id));
  }

  @Override
  public R addMenu(Menu menu) {
    Menu save = menuRepository.insert(menu);
    return R.success(save);
  }

  @Override
  public R updateMenu(Menu menu) {
    Menu save = menuRepository.save(menu);
    return R.success(save);
  }

  @Override
  public R delMenu(List<String> ids) {
    menuRepository.deleteAllById(ids);
    return R.success();
  }

  @Override
  public R getMenuList(Menu menu) {
    return R.success(menuRepository.findAll(Example.of(menu)));
  }
}
