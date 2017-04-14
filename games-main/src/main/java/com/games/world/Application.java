package com.games.world;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@SpringBootApplication
@Configuration
//@EnableAutoConfiguration
//自动扫描根包名为com.eht.y1da的包。
@ComponentScan(basePackages = { "com.games.world" }) //此处添加的不同的包名（即根包名不是com.eht.y1da）的时候，添加相应的根包名即可。
@Controller
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		log.debug("E答项目启动");
		SpringApplication.run(Application.class, args);
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(){
//		return "redirect:/oauth?p=exrm01";
		return "redirect:/oauth?p=sxam01";
	}
}
