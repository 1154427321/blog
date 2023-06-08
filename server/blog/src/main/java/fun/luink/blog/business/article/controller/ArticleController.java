package fun.luink.blog.business.article.controller;

import fun.luink.blog.business.article.service.ArticleService;
import fun.luink.blog.common.model.ResultObj;
import fun.luink.blog.model.Article;

import java.lang.String;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/article")
@Tag(name = "文章相关接口")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @Operation(summary = "获取文章", description = "获取文章")
    @GetMapping("/getArticle/{id}")
    public ResultObj getArticle(@PathVariable("id") String id) {
        return articleService.getArticle(id);
    }

    @Operation(summary = "添加文章", description = "添加文章")
    @PutMapping("/addArticle")
    public ResultObj addArticle(Article article) {
        return articleService.addArticle(article);
    }

    @Operation(summary = "更新文章", description = "更新文章")
    @PutMapping("/updateArticle")
    public ResultObj updateArticle(Article article) {
        return articleService.updateArticle(article);
    }

    @Operation(summary = "删除文章", description = "删除文章")
    @DeleteMapping("/delArticle")
    public ResultObj delArticle(List<String> article) {
        return articleService.delArticle(article);
    }

    @Operation(summary = "获取文章列表", description = "获取文章列表")
    @PostMapping("/getArticleList")
    public ResultObj getArticleList(Article article) {
        return articleService.getArticleList(article);
    }
}
