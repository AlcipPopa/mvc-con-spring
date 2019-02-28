package eu.alchip.config;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.SpringProperties;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.EncodedResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;


/**
 * Classe utile per la gestione della VIEW
 */
@Configuration
@EnableWebMvc
@ComponentScan("eu.alchip.controllers")
public class WebConfig implements WebMvcConfigurer {


    @Bean
    public SpringResourceTemplateResolver springTemplateResolver(ApplicationContext applicationContext){
        SpringResourceTemplateResolver springTemplateResolver = new SpringResourceTemplateResolver();
        springTemplateResolver.setApplicationContext(applicationContext);
        springTemplateResolver.setPrefix("/WEB-INF/templates/");
        springTemplateResolver.setSuffix(".html");

        return springTemplateResolver;
    }

    @Bean
    public SpringTemplateEngine springTemplateEngine(ApplicationContext applicationContext){
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(springTemplateResolver(applicationContext));
        return springTemplateEngine;
    }


    @Bean
    public ViewResolver viewResolver(ApplicationContext applicationContext) {
        ThymeleafViewResolver resolver =
                new ThymeleafViewResolver();
        resolver.setTemplateEngine(springTemplateEngine(applicationContext));
        return resolver;
    }


    // aggiunge pattern personalizzati delle risorse statiche,
    // setta la durata Cache in secondi ed eventualmente
    // comunica i header in formato compresso con EncodedResourceResolver()
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/css/**", "/img/**")
                .addResourceLocations("/WEB-INF/resources/css/", "/WEB-INF/resources/img/")
                .setCachePeriod(3600)
                .resourceChain(true)
                .addResolver(new EncodedResourceResolver())
                .addResolver(new PathResourceResolver());
    }

    // configuratore dei contenuti statici:
    // asking DispatcherServlet to forward
    // requests for static resources to the servlet container’s default servlet and not to try to
    // handle them itself.
     @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    public void configureSpringProperties(){
        SpringProperties.setProperty("spring.thymeleaf.cache", "false");
    }
}
