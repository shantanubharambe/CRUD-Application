package J_SpringMvcCurdApp.J_SpringMvcCurdApp.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import J_SpringMvcCurdApp.J_SpringMvcCurdApp.model.Employee;

@Repository("emprepo")
public class empRepo {
@Autowired
JdbcTemplate template;
List <Employee>list;
	public boolean isAddEmp(final Employee emp) {
	
	int v=template.update("insert into employee values('0',?,?,?)",new PreparedStatementSetter() {

		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getEmail());
			ps.setString(3, emp.getContact());
			
		}});
		
    return v>0;       	
	}
	public List<Employee> isViewEmp(){
		
		list=template.query("select *from employee", new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                 Employee e=new Employee();
                  e.setId(rs.getInt(1));
                  e.setName(rs.getString(2));
                  e.setEmail(rs.getString(3));
                  e.setContact(rs.getString(4));
                  return e;                
	
			}});
           
		return list;
		
	}

public boolean isdeleteEmp(int id) {
  
	 int val=template.update("delete from employee where id=?",new Object[] {id});
     return val>0;
	 
}public boolean isUpdate(final Employee e) {
	
    int val = template.update("UPDATE employee SET name=?, email=? ,contact=? WHERE id=?",
            new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setString(1, e.getName());
                    ps.setString(2, e.getEmail());
                    ps.setString(3, e.getContact());     
                    ps.setInt(4, e.getId());
                }
            }
        );

        return val > 0;
    }
public List<Employee> isSearchEmp(String name){
System.out.println(name);
	list=template.query("select *from employee where name like '%"+name+"%'", new RowMapper() {

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
             Employee e=new Employee();
              e.setId(rs.getInt(1));
              e.setName(rs.getString(2));
              e.setEmail(rs.getString(3));
              e.setContact(rs.getString(4));
              return e;                

		}});
	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa"+list);
	return list;
	
}
}


