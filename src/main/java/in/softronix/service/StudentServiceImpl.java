package in.softronix.service;

import java.util.List;
import in.softronix.dao.StudentDao;
import in.softronix.entity.Student;
import in.softronix.factory.DaoFactory;

public class StudentServiceImpl implements StudentService {
	String status="";
	StudentDao dao=DaoFactory.getDao();
	
	@Override
	public String addstudent(Student std) {
		status=dao.add(std);
		return status;
	}

	@Override
	public Student searchStudent(int sid) {
		Student student = dao.search(sid);
		return student;
	}

	@Override
	public String updateStudent(Student std) {
		status = dao.update(std);
		return  status;
	}

	@Override
	public String deleteStudent(int sid) {
		
		status=dao.delete(sid);
		return status;
	}

	@Override
	public List<Student> getStudent() {
		List<Student> allStudent =dao.getAllStudent();
		
		return allStudent;
	}

}
