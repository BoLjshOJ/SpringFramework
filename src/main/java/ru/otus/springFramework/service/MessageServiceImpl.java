package ru.otus.springFramework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageSource messageSource;
    private String locale;

    @Autowired
    public MessageServiceImpl(
            MessageSource messageSource,
            @Value("${locale}") String locale) {
        this.messageSource = messageSource;
        this.locale = locale;
    }

    @Override
    public String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, getLocale());
    }

    @Override
    public String getMessage(String code) {
        return getMessage(code, null);
    }

    @Override
    public Locale getLocale() {
        return Locale.forLanguageTag(locale);
    }
}
