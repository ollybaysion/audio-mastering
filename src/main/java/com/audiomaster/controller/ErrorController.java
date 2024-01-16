package com.audiomaster.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("error")
@Controller
public class ErrorController {

    @GetMapping
    public String mastering(ModelMap map) {
        return "/error";
    }
}
