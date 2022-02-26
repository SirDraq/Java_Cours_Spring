package com.AndrzejJarosz.module.pdf;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class PdfGeneratorRestController {

    @Autowired
    private PdfGeneratorService pdfGeneratorService;

    @GetMapping("/pdf/generator")
    public PdfStatusResponse generate() {
        String fileName = pdfGeneratorService.generatePdf("Michal Szałkowski");
        return new PdfStatusResponse().setFileName(fileName);
    }

    @GetMapping("/pdf")
    public void getPdfFile(
            @RequestParam("name") String name,
            HttpServletResponse response) throws IOException {

        String fileFullPath = pdfGeneratorService.generatePdf(name);

        InputStream myStream = new FileInputStream(fileFullPath);

        response.addHeader("Content-disposition", "filename=" + fileFullPath);
        response.setContentType("application/pdf");
        IOUtils.copy(myStream, response.getOutputStream());
        response.flushBuffer();
    }

}