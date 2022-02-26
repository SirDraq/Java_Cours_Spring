package com.AndrzejJarosz.module.media;

import com.AndrzejJarosz.module.media.reposytory.MediaRepository;
import com.AndrzejJarosz.module.media.storage.FileSystemStorage;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class FileUploadController {

    @Autowired
    private FileSystemStorage storage;

    @GetMapping("/media")
    public String getMediaPage(Model model) {
        model.addAttribute("files", storage.list());
        return "media/index.html";
    }

    @PostMapping("/media")
    public String saveFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
        storage.store(file);
        redirectAttributes.addFlashAttribute(
                "message",
                "You successfully uploaded " + file.getOriginalFilename()
        );

        return "redirect:/media";
    }

    @GetMapping({"/media/{uuid}.jpg"})
    public void getFile(@PathVariable String uuid, HttpServletResponse response) throws IOException {

        String fileFullPath = storage.getFileFullPath(uuid);

        InputStream myStream = new FileInputStream(fileFullPath);
        response.addHeader("Content-disposition", "filename=" + fileFullPath);
        response.setContentType("image/png");
        IOUtils.copy(myStream, response.getOutputStream());
        response.flushBuffer();
    }
}