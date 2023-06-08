package fun.luink.blog.system.service;

import fun.luink.blog.common.model.ResultObj;
import fun.luink.blog.model.Menu;
import java.lang.String;
import java.util.List;

public interface MenuService {
  ResultObj getMenu(String id);

  ResultObj addMenu(Menu menu);

  ResultObj updateMenu(Menu menu);

  ResultObj delMenu(List<String> menu);

  ResultObj getMenuList(Menu menu);
}
