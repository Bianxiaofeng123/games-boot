package com.games.world;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import groovy.util.logging.Log4j;


@Log4j
@SpringBootApplication
@Configuration
//@EnableAutoConfiguration
//自动扫描根包名为com.eht.y1da的包。
@ComponentScan(basePackages = { "com.games.world" }) //此处添加的不同的包名（即根包名不是com.games.world）的时候，添加相应的根包名即可。
@Controller
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(){
//		return "redirect:/oauth?p=exrm01";
		return "redirect:/oauth?p=sxam01";
	}
}
