package com.greenuniv.greenuniv.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HeaderController {


    @GetMapping("/login/login")
    public String login(){return "login/login";}

    @GetMapping("/introduce/map")
    public String map(){return "introduce/map";}

    @GetMapping("/introduce/greeting")
    public String greeting(){return "/introduce/greeting";}

    @GetMapping("/introduce/history")
    public String history(){return "/introduce/history";}

    @GetMapping("/introduce/ideology")
    public String ideology(){return "/introduce/ideology";}

    @GetMapping("/introduce/organization")
    public String organization(){return "/introduce/organization";}

    @GetMapping("/introduce/advice")
    public String advice(){return "/introduce/advice";}

    @GetMapping("/university/humanities")
    public String humanities(){return "/university/humanities";}

    @GetMapping("/university/naturalScience")
    public String naturalScience(){return "/university/naturalScience";}

    @GetMapping("/university/engineering")
    public String engineering(){return "/university/engineering";}

    @GetMapping("/university/education")
    public String education(){return "/university/education";}

    @GetMapping("/university/graduate")
    public String graduate(){return "/university/graduate";}

    @GetMapping("/academicInformation/notice")
    public String notice(){return "/academicInformation/notice";}

    @GetMapping("/academicInformation/schedule")
    public String schedule(){return "/academicInformation/schedule";}

    @GetMapping("/academicInformation/registration")
    public String registration(){return "/academicInformation/registration";}

    @GetMapping("/academicInformation/score")
    public String score(){return "/academicInformation/score";}

    @GetMapping("/academicInformation/graduation")
    public String graduation(){return "/academicInformation/graduation";}

    @GetMapping("/academicInformation/qna")
    public String qna(){return "/academicInformation/qna";}

    @GetMapping("/collegeLife/club")
    public String club(){return "/collegeLife/club";}

    @GetMapping("/collegeLife/diet")
    public String diet(){return "/collegeLife/diet";}

    @GetMapping("/collegeLife/council")
    public String council(){return "/collegeLife/council";}

    @GetMapping("/collegeLife/gallery")
    public String gallery(){return "/collegeLife/gallery";}




}

