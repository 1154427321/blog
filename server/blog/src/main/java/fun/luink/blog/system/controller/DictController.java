package fun.luink.blog.system.controller;

import fun.luink.blog.common.model.R;
import fun.luink.blog.model.Dict;
import fun.luink.blog.system.service.DictService;

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
@RequestMapping("/dict")
@Tag(name = "字典管理", description = "字典管理")
public class DictController {
    @Autowired
    DictService dictService;

    @GetMapping("/getDict/{id}")
    @Operation(summary = "获取字典", description = "获取字典")
    public R getDict(@PathVariable("id") String id) {
        return dictService.getDict(id);
    }

    @PutMapping("/addDict")
    @Operation(summary = "添加字典", description = "添加字典")
    public R addDict(Dict dict) {
        return dictService.addDict(dict);
    }

    @PutMapping("/updateDict")
    @Operation(summary = "更新字典", description = "更新字典")
    public R updateDict(Dict dict) {
        return dictService.updateDict(dict);
    }

    @DeleteMapping("/delDict")
    @Operation(summary = "删除字典", description = "删除字典")
    public R delDict(List<String> dict) {
        return dictService.delDict(dict);
    }

    @PostMapping("/getDictList")
    @Operation(summary = "获取字典列表", description = "获取字典列表")
    public R getDictList(Dict dict) {
        return dictService.getDictList(dict);
    }
}
