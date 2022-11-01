package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Class;
import dmacc.repository.ClassRepository;

/**
 * @author alexh - aheinrichs
 * CIS175 - Fall 2022
 * Oct 29, 2022
 */
@Controller
public class WebController {
	@Autowired
	ClassRepository repo;
	
	@GetMapping("/" + "viewAll")
	public String viewAllClasses(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewClass(model);
		}
		model.addAttribute("classes", repo.findAll());
		return "results";
	}
	
	@GetMapping("/addClass")
	public String addNewClass(Model model) {
		Class c = new Class();
		model.addAttribute("newClass", c);
		return "input";
	}
	
	@PostMapping("/addClass")
	public String addNewClass(@ModelAttribute Class c, Model model) {
		repo.save(c);
		return viewAllClasses(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateClass(@PathVariable("id") long id, Model model) {
		Class c = repo.findById(id).orElse(null);
		System.out.println("ITEM TO EDIT: " + c.toString());
		model.addAttribute("newClass", c);
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String reviseClass(Class c, Model model) {
		repo.save(c);
		return viewAllClasses(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Class c = repo.findById(id).orElse(null);
	    repo.delete(c);
	    return viewAllClasses(model);
	}
	
}
