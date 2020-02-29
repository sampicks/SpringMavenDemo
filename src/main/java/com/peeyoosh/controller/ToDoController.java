package com.peeyoosh.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.peeyoosh.model.Todo;
import com.peeyoosh.service.ToDoService;

@Controller
@SessionAttributes("username")
public class ToDoController {

	@Autowired
	private ToDoService service;

	@InitBinder
	protected void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodoList(ModelMap modelMap) {
		modelMap.addAttribute("todoList", service.retrieveTodos(getLoggedInUsername()));
		return "list-todos";
	}
	private String getLoggedInUsername() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		// principal object is logged in user object.
		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String addTodo(ModelMap modelMap) {
		modelMap.addAttribute("todo", new Todo(0, getLoggedInUsername(), "", new Date(), false));
		/**
		 * In add-todo.jsp form section we are not defining action hence (previous url)
		 * /add-todo action will be continue with form add-todo.jsp
		 */
		return "add-todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodoAndRedirect(ModelMap modelMap, @Valid Todo todo, BindingResult bindingResult) {
		/**
		 * Here we are using @Valid annotation for hence BindingResult is used to get
		 * validation result
		 */
		if (bindingResult.hasErrors()) {
			return "add-todo";
		}
		service.addTodo(getLoggedInUsername(), todo.getDesc(), new Date(), false);
		modelMap.clear(); /** It will protect to append query string to the url. */
		/**
		 * It will simply return the file name hence no attribute is set into
		 * list-todos.jsp file
		 */
//		return "list-todos"; 
		return "redirect:list-todos"; /** It is redirecting the url hence showTodoList method will process it */
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String updateTodo(ModelMap modelMap, @RequestParam int id) {
		Todo updateTodo= service.retrieveTodo(id);
		modelMap.addAttribute("todo", updateTodo);
		return "add-todo"; 
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodoAndRedirect(ModelMap modelMap, @Valid Todo todo, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "add-todo";
		}
		todo.setUser(getLoggedInUsername());
		service.updateTodo(todo);
		modelMap.clear();
		return "redirect:list-todos";
	}
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(ModelMap modelMap, @RequestParam int id) {
		/**
		 * http://localhost:8080/list-todos?username=Peeyoosh : username=Peeyoosh
		 * parameter will be removed by this.
		 */
		modelMap.clear();
		service.deleteTodo(id);
		return "redirect:list-todos"; /** It is redirecting the url hence showTodoList method will process it */
	}

}
