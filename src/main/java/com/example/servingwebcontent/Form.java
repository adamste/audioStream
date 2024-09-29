package com.example.servingwebcontent;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class Form {
    private String content;
    private MultipartFile file;
}
