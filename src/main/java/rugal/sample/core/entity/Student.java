package rugal.sample.core.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

/**
 *
 * @author rugal
 */
@Data
@Entity(name = "student")
@Table(name = "student")
public class Student
{

    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(length = 20)
    private String name;

    @Column
    private Integer age;
    
    //Getters

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}
    
	//Setters
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	//ToString
	
	
	
    
}
