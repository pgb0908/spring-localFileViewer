package com.gyubong.myFileViewer.controller;

import com.gyubong.myFileViewer.domain.FileInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

@Controller
public class DashBoardController {

    @GetMapping("/dashboard")
    public String dashboardPage(Model model) {

        // 파일에 출력할 리스트 뽑기
        ArrayList<FileInfo> fileInfoList;
        String filePath;

        filePath = "C:/Users/Tmax/test";
        File file = new File(filePath);
        fileInfoList = getFileInfoListing(file);

        model.addAttribute("fileInfo", fileInfoList);
        model.addAttribute("pDir", file.getParent());

        return "dashboard";
    }


    private ArrayList<FileInfo> getFileInfoListing(File dir) {
        //C:\Users\Tmax\springMVC
        File[] files = dir.listFiles();

        // fileInfo class로 만들라...
        ArrayList<FileInfo> fileInfoList = new ArrayList();

        for (File file : files) {
            FileInfo fileInfo = new FileInfo();

            fileInfo.setFileName(file.getName());
            fileInfo.setFileSize(file.length());
            fileInfo.setLastMoified(file.lastModified());
            fileInfo.setParentFile(file.getParentFile());
            fileInfo.setFileDir(dir.getAbsolutePath());

            fileInfoList.add(fileInfo);
        }

        Collections.sort(fileInfoList, (a, b) -> (int) (long) a.getFileSize() -  (int) (long) b.getFileSize());

        return fileInfoList;
    }

}

