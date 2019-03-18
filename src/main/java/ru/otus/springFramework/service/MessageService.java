package ru.otus.springFramework.service;

import java.util.Locale;

public interface MessageService {
    String getMessage(String code, Object[] args);
    String getMessage(String code);
    Locale getLocale();
}
