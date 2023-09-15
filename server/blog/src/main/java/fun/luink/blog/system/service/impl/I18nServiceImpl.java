package fun.luink.blog.system.service.impl;

import fun.luink.blog.system.service.I18nService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service("i18nService")
public class I18nServiceImpl implements I18nService {
 
    @Autowired
    private MessageSource messageSource;
 
    @Override
    public String getMessage(String msgKey, Object[] args) {
        return messageSource.getMessage(msgKey, args, LocaleContextHolder.getLocale());
    }
 
    @Override
    public String getMessage(String msgKey) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(msgKey, null, locale);
    }
}