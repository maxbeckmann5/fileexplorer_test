package com.example.fileexplorer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class FileController {

    @GetMapping("/")
    public String getFileList(Model model) {
        String path = "files";
        File directory = new File(path);
        File[] files = directory.listFiles();

        List<String> fileNames = new ArrayList<>();
        if (files != null) {
            Arrays.sort(files);
            for (File file : files) {
                fileNames.add(file.getName());
            }
            model.addAttribute("fileNames", fileNames);
        }

        return "fileExplorer";
    }
}
