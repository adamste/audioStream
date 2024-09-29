package com.example.servingwebcontent;

import org.springframework.content.commons.store.ContentStore;
import org.springframework.content.rest.StoreRestResource;

@StoreRestResource(path = "streams")
public interface FileContentStore extends ContentStore<File, String> {
}
