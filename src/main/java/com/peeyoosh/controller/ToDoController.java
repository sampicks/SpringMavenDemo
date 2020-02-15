package com.peeyoosh.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.peeyoosh.service.ToDoService;

@Controller
@SessionAttributes("username")
public class ToDoController {

	@Autowired
	private ToDoService service;

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodoList(ModelMap modelMap) {
		modelMap.addAttribute("todoList", service.retrieveTodos("Peeyoosh"));
		return "list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String addTodo() {
		return "add-todo";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodoAndRedirect(ModelMap modelMap, @RequestParam String desc) {
		service.addTodo("Peeyoosh", desc, new Date(), false);
		modelMap.clear(); // It will protect to append query string to the url.
//		return "list-todos"; /** It will simply return the file name hence no attribute is set into listtodo file */
		return "redirect:list-todos"; /** It is redirecting the url hence showTodoList method will process it*/
	}
}
