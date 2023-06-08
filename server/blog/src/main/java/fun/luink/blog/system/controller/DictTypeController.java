package fun.luink.blog.system.controller;

import fun.luink.blog.common.model.ResultObj;
import fun.luink.blog.model.DictType;
import fun.luink.blog.system.service.DictTypeService;
import java.lang.String;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dictType")
@Tag(name = "字典类型管理", description = "字典类型管理")
public class DictTypeController {
  @Autowired
  DictTypeService dictTypeService;

  @GetMapping("/getDictType/{id}")
  @Operation(summary = "获取字典类型", description = "获取字典类型")
  public ResultObj getDictType(@PathVariable("id") String id) {
    return dictTypeService.getDictType(id);
  }

  @PutMapping("/addDictType")
    @Operation(summary = "添加字典类型", description = "添加字典类型")
  public ResultObj addDictType(DictType dictType) {
    return dictTypeService.addDictType(dictType);
  }

  @PutMapping("/updateDictType")
    @Operation(summary = "更新字典类型", description = "更新字典类型")
  public ResultObj updateDictType(DictType dictType) {
    return dictTypeService.updateDictType(dictType);
  }

  @DeleteMapping("/delDictType")
    @Operation(summary = "删除字典类型", description = "删除字典类型")
  public ResultObj delDictType(List<String> dictType) {
    return dictTypeService.delDictType(dictType);
  }

  @PostMapping("/getDictTypeList")
    @Operation(summary = "获取字典类型列表", description = "获取字典类型列表")
  public ResultObj getDictTypeList(DictType dictType) {
    return dictTypeService.getDictTypeList(dictType);
  }
}
