package com.AndrzejJarosz.module.pdf;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;


@Service
public class PdfGeneratorService {

    @Value("${mediaRootLocation}")
    private String path;

    public String generatePdf(String userName) {

        String fullPathWithName = path + File.separator + String.format("file_%s.pdf", UUID.randomUUID().toString());

        try {
            String html = parseThymeleafTemplate(userName);
            generatePdfFromHtml(html, fullPathWithName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fullPathWithName;
    }

    public void generatePdfFromHtml(String html, String outputFolder) throws IOException, DocumentException {
        OutputStream outputStream = new FileOutputStream(outputFolder);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(outputStream);

        outputStream.close();
    }

    public String parseThymeleafTemplate(String userName) {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        context.setVariable("userName", userName);

        return templateEngine.process("thymeleaf_template", context);
    }

}
