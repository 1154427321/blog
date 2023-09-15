package fun.luink.blog.system.service;

public interface I18nService {
 
    String getMessage(String msgKey);
 
    String getMessage(String msgKey, Object[] args);
}