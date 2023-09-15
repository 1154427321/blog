package fun.luink.blog.system.service;

import fun.luink.blog.common.model.R;
import fun.luink.blog.model.DictType;
import java.lang.String;
import java.util.List;

public interface DictTypeService {
  R getDictType(String id);

  R addDictType(DictType dictType);

  R updateDictType(DictType dictType);

  R delDictType(List<String> dictType);

  R getDictTypeList(DictType dictType);
}
