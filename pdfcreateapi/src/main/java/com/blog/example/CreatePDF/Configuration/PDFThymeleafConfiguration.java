package com.blog.example.CreatePDF.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.StandardTemplateModeHandlers;

import java.nio.charset.StandardCharsets;

@Configuration
public class PDFThymeleafConfiguration {


    @Bean
    public SpringTemplateEngine springTemplateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addTemplateResolver(htmlTemplateResolver());
        return templateEngine;
    }

    @Bean
    public SpringResourceTemplateResolver htmlTemplateResolver() {
        SpringResourceTemplateResolver pdfTemplateResolver = new SpringResourceTemplateResolver();
        pdfTemplateResolver.setPrefix("classpath:/summaryTemplate/");
        pdfTemplateResolver.setSuffix(".html");
        pdfTemplateResolver.setTemplateMode(StandardTemplateModeHandlers.HTML5.getTemplateModeName());
        pdfTemplateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
        return pdfTemplateResolver;
    }


}



