package fun.luink.blog.system.service;

import fun.luink.blog.common.model.R;
import fun.luink.blog.model.Menu;
import java.lang.String;
import java.util.List;

public interface MenuService {
  R getMenu(String id);

  R addMenu(Menu menu);

  R updateMenu(Menu menu);

  R delMenu(List<String> menu);

  R getMenuList(Menu menu);
}
