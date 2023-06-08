package fun.luink.blog.system.service;

import fun.luink.blog.common.model.ResultObj;
import fun.luink.blog.model.Dict;
import java.lang.String;
import java.util.List;

public interface DictService {
  ResultObj getDict(String id);

  ResultObj addDict(Dict dict);

  ResultObj updateDict(Dict dict);

  ResultObj delDict(List<String> dict);

  ResultObj getDictList(Dict dict);
}
