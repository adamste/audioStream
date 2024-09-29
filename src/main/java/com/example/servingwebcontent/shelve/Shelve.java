package com.example.servingwebcontent.shelve;

import com.example.servingwebcontent.files.File;
import com.example.servingwebcontent.users.User;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity

public class Shelve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    @ElementCollection
    private List<Long> fileIds;
}
