package in.softronix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import in.softronix.entity.Student;
import in.softronix.factory.ConnectionFactory;

public class StudentDaoImpl implements StudentDao {
	
	 String status="";
	    Connection con=ConnectionFactory.getConnection();
	    String sql="";
	    Student std=new Student();
	    
		@Override
		public String add(Student std) {
			try {
				int sid=std.getSid();
				String sname=std.getSname();
				float smarks=std.getSmarks();
				String saddr=std.getSaddr();
				
				sql="insert into student values(?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(sql);
				
				ps.setInt(1, sid);
				ps.setString(2, sname);
				ps.setFloat(3, smarks);
				ps.setString(4, saddr);
				
				
				ps.execute();
				status="success";
			} catch (SQLException e) {
				status="failure";
				e.printStackTrace();
			}
			
			return status;
		}

		@Override
		public Student search(int sid) {
			Student s=new Student();
	     try {
	    	 sql="select * from student where sid=?";
	    	 PreparedStatement ps=con.prepareStatement(sql);
			
	    	 ps.setInt(1, sid);
	    	 ResultSet rs= ps.executeQuery();
	    	 
	    	 s.setSid(Integer.parseInt(rs.getString("SID")));
			   s.setSname(rs.getString("SNAME"));
			   s.setSmarks(Float.parseFloat(rs.getString("SMARKS")));
			   s.setSaddr(rs.getString("SADDR"));
	    	 
	    	 
		} catch (Exception e) {
			e.printStackTrace();
		}
			return s;
		}

		@Override
		public String update(Student std) {
			try {
				
				
				int sid=std.getSid();
				String sname=std.getSname();
				float smarks=std.getSmarks();
				String saddr=std.getSaddr();
				
				sql="update Student set sname=?,smarks=?,saddr=? where sid=?";
				PreparedStatement ps=con.prepareStatement(sql);
				
				ps.setInt(1, sid);
				ps.setString(2, sname);
				ps.setFloat(3, smarks);
				ps.setString(4, saddr);
				
				
				ps.execute();
				status="success";
				
			} catch (SQLException e) {
				
				status="failure";
				e.printStackTrace();
			}
			
			return status;
		}

		@Override
		public String delete(int sid) {
			try {
				
				sql="delete from student where sid=?";
				
				PreparedStatement ps=con.prepareStatement(sql);
				
				ps.setInt(1, sid);
				
				boolean b = ps.execute();
				
				
					status="delete";
					
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return status;
		}

		@Override
		public List<Student> getAllStudent() {
			List<Student> std=new ArrayList<Student>();
			try {
				sql="select * from student";
				PreparedStatement ps=con.prepareStatement(sql);
			   ResultSet rs = ps.executeQuery();
			   
			   while(rs.next())
			   
			   {
				   Student s=new Student();
				   s.setSid(Integer.parseInt(rs.getString("SID")));
				   s.setSname(rs.getString("SNAME"));
				   s.setSmarks(Float.parseFloat(rs.getString("SMARKS")));
				   s.setSaddr(rs.getString("SADDR"));
				  
				   std.add(s);
			   }
			   
			   
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return std ;
		}

}
