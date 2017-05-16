package org.foobarspam.cotxox.controller;

import org.foobarspam.cotxox.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by palliser on 16/05/2017.
 */
@Controller
public class CarreraController {



	@RequestMapping(path="/")
	public String home(Model model) {

		model.addAttribute("nombre", "GoogleMaps");
		return "index";
	}
}
