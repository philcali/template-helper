package me.philcali.template.api;

import me.philcali.template.api.exception.TemplateNotFoundException;

public interface TemplateEngineProvider {
    TemplateEngine get(String templateId) throws TemplateNotFoundException;
}
