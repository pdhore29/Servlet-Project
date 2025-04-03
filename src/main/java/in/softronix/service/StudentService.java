package in.softronix.service;

import java.util.List;
import in.softronix.entity.Student;

public interface StudentService {
	
	public String addstudent(Student std);
	public List<Student> getStudent();
	public Student searchStudent(int sid);
	public String updateStudent(Student std);
	public String deleteStudent(int sid);

}
