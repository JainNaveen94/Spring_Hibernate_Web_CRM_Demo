package com.nagarro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.entity.Customer;
import com.nagarro.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// Need To Inject CustomerService
	@Autowired
	private CustomerService customerService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, editor);
	}
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		// get Customers From The Service
		List<Customer> customers = customerService.getCustomers();
		
		// Add The Customer to The Model
		model.addAttribute("customers", customers);
		
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "customer-form";
		} else {
			
			// Save Customer To The DataBase
			customerService.addCustomer(customer);
			
			return "redirect:/customer/list";
		}
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerID") int id, Model model) {
		
		//Get The Customer From The DB
		Customer customer = customerService.getCustomer(id);
		
		// set The Customer Record Into The Model For Show Into Form
		model.addAttribute("customer", customer);
		
		// send the Model And Redirect to Customer Add Form
		
		return "customer-form";
		
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerID") int id) {
		
		// Delete The Customer Through Service Method
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}

}
