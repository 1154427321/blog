package fun.luink.blog.system.service.impl;

import fun.luink.blog.common.model.ResultObj;
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
  public ResultObj getDictType(String id) {
    return ResultObj.success(dictTypeRepository.findById(id));
  }

  @Override
  public ResultObj addDictType(DictType dictType) {
    DictType save = dictTypeRepository.insert(dictType);
    return ResultObj.success(save);
  }

  @Override
  public ResultObj updateDictType(DictType dictType) {
    DictType save = dictTypeRepository.save(dictType);
    return ResultObj.success(save);
  }

  @Override
  public ResultObj delDictType(List<String> ids) {
    dictTypeRepository.deleteAllById(ids);
    return ResultObj.success();
  }

  @Override
  public ResultObj getDictTypeList(DictType dictType) {
    return ResultObj.success(dictTypeRepository.findAll(Example.of(dictType)));
  }
}
