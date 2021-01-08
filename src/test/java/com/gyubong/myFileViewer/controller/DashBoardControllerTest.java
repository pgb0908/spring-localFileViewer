package com.gyubong.myFileViewer.controller;

import com.gyubong.myFileViewer.domain.FileInfo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

public class DashBoardControllerTest {
    // 파일에 출력할 리스트 뽑기
    ArrayList<FileInfo> fileInfoList;
    String defaultFilePath = "C:/Users/Tmax/test";
    String curDir;
    String newDir;
    String startStr = "/dashboard";

    @Test
    void pathNameTest() {
        // 현재 url 주소
        curDir = "/dashboard/a";

        // newDir = 현주 주소 - /dashboard/
        newDir = curDir.substring(startStr.length());
        System.out.println(newDir);
    }


}
