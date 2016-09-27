package rugal.sample.core.service;

import rugal.sample.core.entity.Student;

import java.util.List;

import rugal.sample.core.dao.StudentDAO;

/**
 *
 * @author Rugal Bernstein
 */
public interface StudentService extends BaseService<StudentDAO>
{

    Student update(Student bean);
    
    List<String> getAllStudents();
}
