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
    String newURL;
    String startStr = "/dashboard";

    @Test
    void pathNameTest() {
        // 현재 url 주소
        curDir = "/dashboard/a";

        // newDir = 현주 주소 - /dashboard/
        newURL = curDir.substring(startStr.length());
        System.out.println("현재주소 : " + newURL);


        // 마지막 / 위치
        int last = 0;
        for(int i = curDir.length()-1; i >= 0; i--){
            if('/' == curDir.charAt(i)){
                last = i;
                break;
            }
        }
        System.out.println(last);
        System.out.println("lastURL : " + curDir.substring(0, last));
        //String parentURL = newURL.substring()

    }


}
