package me.philcali.template.api;

import java.util.Optional;

import me.philcali.template.annotation.Template;
import me.philcali.template.api.exception.TemplateNotFoundException;

public interface TemplateEngineProvider {
    TemplateEngine get(String templateId) throws TemplateNotFoundException;

    default TemplateEngine get(final Template template) {
        return Optional.ofNullable(template).map(t -> {
            final TemplateEngine engine = new TemplateEngineComposite(get(t.value()));
            engine.templatePrefix(t.location());
            engine.templatePrefix(Template.DEFAULT_LOCATION);
            return engine;
        }).orElseGet(() -> {
            return get(Template.DEFAULT_ENGINE);
        });
    }
}
