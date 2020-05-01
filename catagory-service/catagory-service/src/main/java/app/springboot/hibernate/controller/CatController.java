package app.springboot.hibernate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import app.springboot.hibernate.dto.Catagory;
import app.springboot.hibernate.service.CatService;

@RestController
public class CatController {

	@Autowired
	private CatService catService;

	/*
	 * @RequestMapping(value = "/") public ModelAndView
	 * listCatgory(ModelAndView model) throws IOException { List<Catgory>
	 * listCatgory = CatgoryService.getAllCatgorys();
	 * model.addObject("listCatgory", listCatgory); model.setViewName("home");
	 * return model; }
	 */

	@RequestMapping(value = "/")
	public List<Catagory> listCatgory(ModelAndView model) throws IOException {
		List<Catagory> listCatgory = catService.getAllCatagory();
		return listCatgory;
	}

	@RequestMapping(value = "/saveCatgory", method = RequestMethod.POST)
	public String saveCatgory(@RequestBody Catagory Catgory) {
		if (Catgory.getId() == 0) { // if Catgory id is 0 then creating the
			// Catgory other updating the Catgory
			catService.addCatagory(Catgory);
		} else {
			catService.updateCatagory(Catgory);
		}
		return Catgory.toString();
	}
	
	@RequestMapping(value = "/deleteCatgory", method = RequestMethod.GET)
	public String deleteCatgory(HttpServletRequest request) {
		int CatgoryId = Integer.parseInt(request.getParameter("id"));
		catService.deleteCatagory(CatgoryId);
		return CatgoryId+" Delete";
	}

	@RequestMapping(value = "/editCatgory", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int CatgoryId = Integer.parseInt(request.getParameter("id"));
		Catagory Catgory = catService.getCatagory(CatgoryId);
		ModelAndView model = new ModelAndView("catForm");
		model.addObject("Catgory", Catgory);
		return model;
	}

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.GET) public
	 * ModelAndView login(ModelAndView model) { model.setViewName("ssoLogin");
	 * return model; }
	 * 
	 * @RequestMapping(value = "/validate", method = RequestMethod.POST) private
	 * ModelAndView validate(@RequestParam("login_email")String
	 * emailId, @RequestParam("login_pwd")String password) {
	 * 
	 * System.out.println(emailId); System.out.println(password);
	 * 
	 * String msg = ""; boolean isValid = catService.validate(emailId,
	 * password);
	 * 
	 * if(isValid) { msg = "Welcome " + emailId + "!"; } else { msg =
	 * "Invalid credentials"; } return new ModelAndView("ssoAdminConfiguration",
	 * "output", msg); }
	 */

}