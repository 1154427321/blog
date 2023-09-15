package fun.luink.blog.system.service.impl;

import fun.luink.blog.common.model.R;
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
  public R getDict(String id) {
    return R.success(dictRepository.findById(id));
  }

  @Override
  public R addDict(Dict dict) {
    Dict save = dictRepository.insert(dict);
    return R.success(save);
  }

  @Override
  public R updateDict(Dict dict) {
    Dict save = dictRepository.save(dict);
    return R.success(save);
  }

  @Override
  public R delDict(List<String> ids) {
    dictRepository.deleteAllById(ids);
    return R.success();
  }

  @Override
  public R getDictList(Dict dict) {
    return R.success(dictRepository.findAll(Example.of(dict)));
  }
}
