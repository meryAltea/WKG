package br.com.wkgcosmeticos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
	@RequestMapping(value="/")
	public String irParaHome(){
		return "index";
	}
}
