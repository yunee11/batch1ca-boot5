package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.dto.EmployeeDTO;
import com.main.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;


	@GetMapping("login") //in url write this to call login.jsp
	String displayLoginPage(){

		return "login";//login.jsp

	}

	//authenticate using service layer
	@PostMapping("login")
	String authenticate(@RequestParam String email ,@RequestParam String password ,Model model){  //HttpServletRequest request

		System.out.println(email +"   "+password);
		System.out.println("from controller..........");

		EmployeeDTO employeeDTO = employeeService.authenticate(email, password);

		if (employeeDTO!=null){

			model.addAttribute("employeeDTO", employeeDTO);

			return "congrats";

		}
		else 
		{

			model.addAttribute("msg", "invalid user");

			return "login";
		}
	}

	@GetMapping ("showEmployees")
	String showall(Model model) {


		List<EmployeeDTO>   employeeDTOlist=employeeService.FetchAllEmployees();	   

		System.out.println(employeeDTOlist);
		model.addAttribute( "employeeDTOlist"  ,employeeDTOlist);


		return"showAllEmp";
	}

	@GetMapping("register")
	String displayRegistrationPage(){

		return "registration";

	}


	@PostMapping("register")
	String doRegistration(@ModelAttribute EmployeeDTO empDTO){

		System.out.println(empDTO);
		employeeService.save(empDTO);

		return "login";

	}
}
