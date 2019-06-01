package tasks.controller;

//import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;

import tasks.dao.TaskDao;

import tasks.modelo.Task;

@Controller
public class TasksController {

	private final TaskDao dao;
	
	public TasksController() {
		dao = new TaskDao();
	}
	
	@RequestMapping("novatask")
	public String form() {
		return "tasks/form-tasks";
	}
	
	@RequestMapping("cadastratask")
	public String cadastra(@Valid Task task, BindingResult result) {
//		TaskDao dao = new TaskDao();
		if (result.hasFieldErrors("descricao")) {
			return "tasks/form-tasks";
		}
		
		dao.inserir(task);				
		return "tasks/task-cadastrada";
	}
	
	@RequestMapping("gettasks")
	//primeira opção usando ModelAndView
//	public string getTasks() {
//		List<Task> tasks = dao.getTasks();
//		
//		ModelAndView mv = new ModelAndView("tasks/get-tasks");
//		mv.addObject("tasks", tasks);
//		
//		return mv;
//	}
	public String getTasks(Model model) {
		model.addAttribute("tasks",dao.getTasks());
		
		return "tasks/get-tasks";
	}
	
	@RequestMapping("excluitask")
	public String exclui(Task task) {
		
		dao.exclui(task);
		//Redirecionamento client Side
		return "redirect:gettasks";
		//Redirecionamento Server Side
		//return "forward:tasks/get-tasks";
	}
	
	@RequestMapping("buscartask")
	public String buscartask(Long id, Model model) {
		
		model.addAttribute(dao.getById(id));		
		//Redirecionamento client Side
		return "tasks/busca-task";
		//Redirecionamento Server Side
		//return "forward:tasks/get-tasks";
	}
	
	@RequestMapping("editatask")
	public String edita(Task task) {
		
		dao.edita(task);
		//Redirecionamento client Side
		return "redirect:gettasks";
		//Redirecionamento Server Side
		//return "forward:tasks/get-tasks";
	}
	
}
