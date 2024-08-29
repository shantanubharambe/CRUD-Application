package J_SpringMvcCurdApp.J_SpringMvcCurdApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import J_SpringMvcCurdApp.J_SpringMvcCurdApp.Repository.empRepo;
import J_SpringMvcCurdApp.J_SpringMvcCurdApp.model.Employee;

@Service("empS")
public class empService {
@Autowired
empRepo emprepo;
public boolean isAddEmp(Employee emp) {
	return emprepo.isAddEmp(emp);
	
}
	
public List<Employee> isViewEmp(){
	return emprepo.isViewEmp();
	
}

public boolean isdeleteEmp(int id) {
	return emprepo.isdeleteEmp(id);
}

public boolean isUpdate(Employee e) {
	return emprepo.isUpdate(e);
}


public List<Employee> isSearchEmp(String name){
	return emprepo.isSearchEmp(name);
	
}
}
