package fun.luink.blog.system.service.impl;

import fun.luink.blog.common.model.ResultObj;
import fun.luink.blog.model.Dict;
import fun.luink.blog.system.repository.DictRepository;
import fun.luink.blog.system.service.DictService;
import java.lang.Override;
import java.lang.String;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class DictServiceImpl implements DictService {
  @Autowired
  DictRepository dictRepository;

  @Override
  public ResultObj getDict(String id) {
    return ResultObj.success(dictRepository.findById(id));
  }

  @Override
  public ResultObj addDict(Dict dict) {
    Dict save = dictRepository.insert(dict);
    return ResultObj.success(save);
  }

  @Override
  public ResultObj updateDict(Dict dict) {
    Dict save = dictRepository.save(dict);
    return ResultObj.success(save);
  }

  @Override
  public ResultObj delDict(List<String> ids) {
    dictRepository.deleteAllById(ids);
    return ResultObj.success();
  }

  @Override
  public ResultObj getDictList(Dict dict) {
    return ResultObj.success(dictRepository.findAll(Example.of(dict)));
  }
}
