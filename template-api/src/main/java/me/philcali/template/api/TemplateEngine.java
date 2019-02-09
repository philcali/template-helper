package me.philcali.template.api;

import me.philcali.template.api.exception.TemplateProcessException;

public interface TemplateEngine {
    String getId();

    String apply(String templateName, Object context) throws TemplateProcessException;

    void templatePrefix(String location);
}
