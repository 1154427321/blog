package fun.luink.blog.system.service.impl;

import fun.luink.blog.common.model.R;
import fun.luink.blog.model.DictType;
import fun.luink.blog.system.repository.DictTypeRepository;
import fun.luink.blog.system.service.DictTypeService;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class DictTypeServiceImpl implements DictTypeService {
  @Autowired
  DictTypeRepository dictTypeRepository;

  @Override
  public R getDictType(String id) {
    return R.success(dictTypeRepository.findById(id));
  }

  @Override
  public R addDictType(DictType dictType) {
    DictType save = dictTypeRepository.insert(dictType);
    return R.success(save);
  }

  @Override
  public R updateDictType(DictType dictType) {
    DictType save = dictTypeRepository.save(dictType);
    return R.success(save);
  }

  @Override
  public R delDictType(List<String> ids) {
    dictTypeRepository.deleteAllById(ids);
    return R.success();
  }

  @Override
  public R getDictTypeList(DictType dictType) {
    return R.success(dictTypeRepository.findAll(Example.of(dictType)));
  }
}
