package com.example.servingwebcontent.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class UploadController {
    @Autowired
    private FileContentStore contentStore;
    @Autowired
    private FileRepository filesRepo;

    @GetMapping("/")
    public String greetingForm(Model model) {
        model.addAttribute("form", new Form());
        return "form";
    }

    @GetMapping("/files")
    public String allFiles(Model model) {
        List<File> files = filesRepo.findAll();
        model.addAttribute("files", files);
        return "files";
    }

    @GetMapping("/listen/{id}")
    public String listen(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "listen";
    }

    @PostMapping("/uploadMultipart")
    public String greetingSubmit(@ModelAttribute Form form, Model model) throws IOException {
        model.addAttribute("greeting", form);

        File file = new File();
        file.setContentMimeType(form.getFile().getContentType());

        InputStream inputStream = form.getFile().getInputStream();
        file.setName(form.getFile().getOriginalFilename());
        file.setSummary(form.getContent());
        contentStore.setContent(file, inputStream);
        filesRepo.save(file);

        model.addAttribute("id", file.getId());

        return "result";
    }
    //0. zrobić dwóch użytkowników

    //1. pliki zapisuja sie w src/main/resources/content_files "jak w s3"
    //2. postgres zamiast h2 w kontenerze
    //3. tabelki: userzy i półki (reposy)
    //4. we froncie: menedżer półek;
    //          1. utwórz półkę(id_usera, pusta lista file)
    //          2. listowanie wszystkich mp3 (z opcją dodaj do swojej półki)
}
