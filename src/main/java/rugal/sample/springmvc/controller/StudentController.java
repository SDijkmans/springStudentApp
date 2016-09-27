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
import org.springframework.web.bind.annotation.PathVariable;
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
@Slf4j
@Controller
@RequestMapping(value = "/student")
public class StudentController
{
	
	private static final Logger _log = LoggerFactory.getLogger(StudentController.class);
	

    @Autowired
    private StudentService studentService;
    

    
    @RequestMapping(method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public List<String> getAllStudents(Model model) {
    	model.addAttribute("students", studentService.getAllStudents());
    	_log.debug("HELLO FROM THE UNDER.. CONTROLLER!");
    	return studentService.getAllStudents();
    }
    
    @RequestMapping(value = "/get")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String now = (new Date()).toString();

        return new ModelAndView("../WEB-INF/views/home.jsp", "now", now);
    }

    /**
     * Persist a student bean into database.
     *
     * @param bean     student bean resembled from request body.
     * @param response
     *
     * @return ID of persisted bean.
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Integer save(@RequestBody Student bean, final HttpServletResponse response)
    {
        response.setStatus(HttpServletResponse.SC_CREATED);
        studentService.getDAO().save(bean);
        return bean.getId();
    }

    /**
     * Update a student bean.
     *
     * @param id       primary key of target student.
     * @param bean     the newer student bean
     * @param response
     *
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") final Integer id, @RequestBody final Student bean,
                       final HttpServletResponse response)
    {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        if (null != studentService.getDAO().get(id))
        {
            studentService.update(bean);
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
    }

    /**
     * DELETE a student record from database.
     *
     * @param id       the target student id.
     * @param response
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") final Integer id, final HttpServletResponse response)
    {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        final Student bean = studentService.getDAO().get(id);
        if (null != bean)
        {
            studentService.getDAO().delete(bean);
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
    }

    /**
     * GET a student record from database.<BR>
     *
     * @param id       primary key of target student.
     * @param response
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object get(@PathVariable("id") final Integer id, final HttpServletResponse response)
    {
        final Student bean = studentService.getDAO().get(id);
        response.setStatus(bean == null ? HttpServletResponse.SC_NOT_FOUND : HttpServletResponse.SC_OK);
        return bean;
    }
}
