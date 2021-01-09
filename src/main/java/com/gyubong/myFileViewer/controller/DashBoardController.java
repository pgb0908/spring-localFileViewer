package com.gyubong.myFileViewer.controller;

import com.gyubong.myFileViewer.domain.FileInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Controller
public class DashBoardController {

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

    @GetMapping("/dashboard/**")
    public String dashboardPage(HttpServletRequest request, Model model) {
        System.out.println("init!!!");

        // 파일에 출력할 리스트 뽑기
        ArrayList<FileInfo> fileInfoList;
        String curURL = "";
        String newURL = "";
        String newFilePath = "";
        String startURL = "/dashboard";
        String defaultFilePath = "C:/Users/Tmax/test";

        // 현재 url 주소
        curURL = request.getRequestURI();

        // newDir = 현주 주소 - /dashboard/
        newURL = curURL.substring(startURL.length());
        // parentURL
        String parentURL = getParentURL(curURL);

        // defaultFilePath + newDir
        newFilePath = defaultFilePath + newURL;


        File file = new File(newFilePath);

        // 해당 디렉토리가 디펙토리인지 파일인지 구분해서
        // 디렉토리이면 이동하고 파일이면 다운받을 수 있다

        // 1 디렉토리인 경우 --> 이동
        fileInfoList = getFileInfoListing(file);

        model.addAttribute("fileInfo", fileInfoList);
        model.addAttribute("pDir", parentURL);

        // 2 파일인경우 --> 다운로드

        return "dashboard";
    }

    private String getParentURL(String curURL) {
        int last = 0;
        int check = 1;
        for(int i = curURL.length()-1; i >= 0; i--){
            if('/' == curURL.charAt(i)){
                if(check == 0){
                    last = i;
                    break;
                }
                check--;

            }
        }

        String result = curURL.substring(0, last);

        return result.isEmpty()? "": result+"/";
    }


    private ArrayList<FileInfo> getFileInfoListing(File dir) {
        //C:\Users\Tmax\springMVC
        File[] files = dir.listFiles();

        // fileInfo class로 만들라...
        ArrayList<FileInfo> fileInfoList = new ArrayList();

        for (File file : files) {
            FileInfo fileInfo = new FileInfo();

            fileInfo.setFileName(file.getName() + "/");
            fileInfo.setFileSize(file.length());
            fileInfo.setLastMoified(file.lastModified());
            fileInfo.setParentFile(file.getParentFile());
            fileInfo.setFileDir(dir.getAbsolutePath());

            fileInfoList.add(fileInfo);
        }

        //Collections.sort(fileInfoList, (a, b) -> (int) (long) a.getFileSize() -  (int) (long) b.getFileSize());

        return fileInfoList;
    }

}

