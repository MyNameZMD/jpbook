package com.jpbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BridgeController {

    @RequestMapping("{name}")
    public void bridge(){}


}
