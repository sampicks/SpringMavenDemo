package com.peeyoosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

}
