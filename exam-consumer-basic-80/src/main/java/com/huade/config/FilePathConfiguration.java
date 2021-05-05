package com.huade.config;


import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "file.path.configuration")
public class FilePathConfiguration {

    private String images;
    private String mode;
    private String file;
    private String bitchPath;

    public String getImages() {
        return images;
    }

    public String getMode() {
        return mode;
    }

    public String getFile() {
        return file;
    }

    public String getBitchPath() {
        return bitchPath;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setBitchPath(String bitchPath) {
        this.bitchPath = bitchPath;
    }

    @Override
    public String toString() {
        return "FilePathConfiguration{" +
                "images='" + images + '\'' +
                ", mode='" + mode + '\'' +
                ", file='" + file + '\'' +
                ", bitchPath='" + bitchPath + '\'' +
                '}';
    }


}
