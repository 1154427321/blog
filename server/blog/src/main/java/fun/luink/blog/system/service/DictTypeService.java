package fun.luink.blog.system.service;

import fun.luink.blog.common.model.ResultObj;
import fun.luink.blog.model.DictType;
import java.lang.String;
import java.util.List;

public interface DictTypeService {
  ResultObj getDictType(String id);

  ResultObj addDictType(DictType dictType);

  ResultObj updateDictType(DictType dictType);

  ResultObj delDictType(List<String> dictType);

  ResultObj getDictTypeList(DictType dictType);
}
