package com.gyubong.myFileViewer.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
public class FileInfo {
    private String fileName;
    private Long fileSize;
    private Long LastMoified;

    private File parentFile;
    private String fileDir;

}
