package J_SpringMvcCurdApp.J_SpringMvcCurdApp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import J_SpringMvcCurdApp.J_SpringMvcCurdApp.model.Employee;
import J_SpringMvcCurdApp.J_SpringMvcCurdApp.service.empService;

@Controller
public class HomeController {
@Autowired
empService empS;
List <Employee>list;

	@RequestMapping(value="/")
	public String test(HttpServletResponse response) throws IOException{
		return "home";
	}
	@RequestMapping(value="/addEmp")
	public String addEmp() {
		return "addEmp";
	}
	@RequestMapping(value="/frmsbt")
	public String formSubmit(Employee emp,Map map) {
	
	map.put("msg", empS.isAddEmp(emp)?"Added Successfully":"Not Added Successfully");	
	return "addEmp";
		
	}
	@RequestMapping(value="/viewEmp")
	public String viewEmp(Map map)  {
		list=empS.isViewEmp();
		map.put("empList", list);
		return "viewEmp";
	}
	
	@RequestMapping(value="/deleteEmp")
	public String deleteEmp(@RequestParam("id") Integer empid,Map map) {

		map.put("del", empS.isdeleteEmp(empid)?"deleted Successfully":"Not deleted Successfully");	
		list=empS.isViewEmp();
		map.put("empList", list);
		
		return "viewEmp";
		
	}
	@RequestMapping(value="/updateEmp")
	public String updateEmp(
			@RequestParam("id") Integer id,
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("contact") String contact,Map map) {
		   map.put("id",id);
		   map.put("name",name);
		   map.put("email",email);
		   map.put("contact",contact);
		  
		return "updateEmp";
	}
	@RequestMapping(value="/frmupdsbt",method = RequestMethod.POST)
	public String formUpdate(Employee emp,Map map) {
      
		
		if(empS.isUpdate(emp)) {
			list=empS.isViewEmp();
			map.put("empList", list);
			return "viewEmp";
		}
		else
		{
			map.put("msg", "Update failed");
			return "updateEmp";
		}
		
	}
	@ResponseBody
	@RequestMapping(value="/searchEmp")
	public String SearchEmployee(@RequestParam("names") String name) {
		list=empS.isSearchEmp(name);
	
		String str = "<table>\n"
		           + "    <thead>\n"
		           + "        <tr>\n"
		           + "            <th class=\"name-header\">Name</th>\n"
		           + "            <th class=\"email-header\">Email</th>\n"
		           + "            <th class=\"contact-header\">Contact</th>\n"
		           + "            <th class=\"actions-header\">Actions</th>\n"
		           + "        </tr>\n"
		           + "    </thead>\n"
		           + "    <tbody>\n";

		// Assume empList is a List<Employee> and is available in your code
		for (Employee e : list) {
		    str += "        <tr>\n"
		         + "            <td class=\"name-cell\">" + e.getName() + "</td>\n"
		         + "            <td class=\"email-cell\">" + e.getEmail() + "</td>\n"
		         + "            <td class=\"contact-cell\">" + e.getContact() + "</td>\n"
		         + "            <td class=\"actions-cell\">\n"
		         + "                <a href=\"updateEmp?id=" + e.getId()
		         + "&name=" + e.getName()
		         + "&email=" + e.getEmail()
		         + "&contact=" + e.getContact()
		         + "\" class=\"update-link\">Update</a>\n"
		         + "                <a href=\"deleteEmp?id=" + e.getId()
		         + "\" class=\"delete-link\">Delete</a>\n"
		         + "            </td>\n"
		         + "        </tr>\n";
		}

		str += "    </tbody>\n"
		     + "</table>";

		
		return str;
	}
}
