package ru.antonsibgatulin.tinder_backend.include.files;

import ru.antonsibgatulin.tinder_backend.dto.DTO;

public class FileUploadResponse extends DTO {
    private String fileName;
    private String downloadUri;
    private long size;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDownloadUri() {
        return downloadUri;
    }

    public void setDownloadUri(String downloadUri) {
        this.downloadUri = downloadUri;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}