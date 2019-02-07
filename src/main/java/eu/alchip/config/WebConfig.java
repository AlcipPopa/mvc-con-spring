package eu.alchip.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
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

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public SpringResourceTemplateResolver springTemplateResolver(){
        SpringResourceTemplateResolver springTemplateResolver = new SpringResourceTemplateResolver();
        springTemplateResolver.setApplicationContext(applicationContext);
        springTemplateResolver.setPrefix("/WEB-INF/templates/");
        springTemplateResolver.setSuffix(".html");
        return springTemplateResolver;
    }

    @Bean
    public SpringTemplateEngine springTemplateEngine(){
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(springTemplateResolver());
        return springTemplateEngine;
    }


    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver resolver =
                new ThymeleafViewResolver();
        resolver.setTemplateEngine(springTemplateEngine());
        return resolver;
    }



    /* // configuratore delle pagine per la view delle JSP
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }
    */
    // configuratore dei contenuti statici:
    // asking DispatcherServlet to forward
    // requests for static resources to the servlet container’s default servlet and not to try to
    // handle them itself.
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
