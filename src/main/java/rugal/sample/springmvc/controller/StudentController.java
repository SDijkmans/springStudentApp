package rugal.sample.springmvc.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import rugal.sample.core.entity.Student;
import rugal.sample.core.service.StudentService;

/**
 *
 * A sample controller class for GET/DELETE/POST/PUT.
 *
 * @author Rugal Bernstein
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController
{
	
	private static final Logger _log = LoggerFactory.getLogger(StudentController.class);
	

    @Autowired
    private StudentService studentService;
    

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getAllStudents() {		
		ModelAndView viewHome = new ModelAndView("home");
		viewHome.getModelMap().addAttribute("students", studentService.getAllStudents());
		viewHome.getModelMap().addAttribute("student", new Student());
		return viewHome;
    }
    
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ModelAndView addNewStudent(@ModelAttribute("student") Student student) {
    	studentService.getDAO().save(student);
    	return getAllStudents();
    }
    


}
