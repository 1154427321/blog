package fun.luink.blog.system.service;

import fun.luink.blog.common.model.R;
import fun.luink.blog.model.Dict;
import java.lang.String;
import java.util.List;

public interface DictService {
  R getDict(String id);

  R addDict(Dict dict);

  R updateDict(Dict dict);

  R delDict(List<String> dict);

  R getDictList(Dict dict);
}
