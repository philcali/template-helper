# Template Helper

Sometimes you have to template things. This library provides an abstraction
around all of those templating things.

## Service Provider

Provide your template engine via a `ServiceLoader` if it existss on the classpath.

## Composite Paths

Sometimes you simply want to override the template used as runtime. This is where
the `TemplateEngineComposite` comes into play:

```java
final TemplateEngineProvider engines = new TemplateEngineProviderSystem();
final TemplateEngine engine = engines.get("handlebars");
final TeamplteEngine compositeEngine = new TemplateEngineComposite(engine);
compositeEngine.templatePrefix("templates/override");
compositeEngine.templatePrefix("templates/override/deeper");

// Several checks are done against the classpath:
// templates/override/deeper/SomeTemplate.hbrs
// templates/override/SomeTemplate.hbrs
// templates/SomeTemplate.hbrs
compositeEngine.apply("SomeTemplate", context);
```
