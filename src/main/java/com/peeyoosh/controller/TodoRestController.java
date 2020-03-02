package com.peeyoosh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.peeyoosh.model.Todo;
import com.peeyoosh.service.ToDoService;

@RestController
public class TodoRestController {

	@Autowired
	ToDoService todoService;

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public List<Todo> retrieveTodos() {
		return todoService.retrieveTodos("Peeyoosh");
	}
	
	@RequestMapping(value = "/todos/{id}", method = RequestMethod.GET)
	public Todo retrieveTodo(@PathVariable int id) {
		return todoService.retrieveTodo(id);
	}
}
