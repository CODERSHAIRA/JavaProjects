package com.beginner.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class ToDoController {

	private ToDoService todoService;
	//constructor injection will enable us to autowire in
	public ToDoController(ToDoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<ToDo> todos = todoService.findByUsername("OMNIFIC ARCANE");
		model.addAttribute("todos", todos);
		return "listTodos";
	}
	@RequestMapping(value="add-todo",method= RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username= (String)model.get("name");
		ToDo todo= new ToDo(0, username,"", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}
	@RequestMapping(value="add-todo",method= RequestMethod.POST)
	public String addNewTodo( ModelMap model, @Valid ToDo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username =(String)model.get("name");
		todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todos";
		
	}
	
	@RequestMapping(value="Update-todo", method= RequestMethod.GET)
	public String showUpdateToDoPage(@RequestParam int id, ModelMap model) {
		ToDo todo= todoService.findById(id);
		model.addAttribute("todo",todo);
		return "todo";
	}
	@RequestMapping(value="Update-todo",method= RequestMethod.POST)
	public String updateTodo( ModelMap model, @Valid ToDo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username =(String)model.get("name");
		todo.setUsername(username);
		todoService.updateToDo(todo);
		return "redirect:list-todos";
	}
}
