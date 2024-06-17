package com.LakshareEventManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.LakshareEventManagement.Model.CustomerEnquireList;
import com.LakshareEventManagement.Services.CustomerEnquireServicesImpl;
import com.LakshareEventManagement.Services.EmailServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerEnquireController {

	@Autowired
	private CustomerEnquireServicesImpl enqService;

	@Autowired
	private EmailServiceImpl emailServiceSender;

	// Handler For Home Page
	@RequestMapping("/")
	public String homePage() {

		return "index";
	}

	@RequestMapping("/adminLogin")
	public String adminLogin() {

		return "AdminLogin";
	}

	@RequestMapping("/adminLoginValidation")
	public String login(@RequestParam String userName, @RequestParam String password, Model model,HttpSession session) {
		boolean authenticated = emailServiceSender.authenticate(userName, password);

		if (authenticated) {
            session.setAttribute("userName", userName); // Store userName in session
            model.addAttribute("userName", userName); // Add userName to the model for the view
            return "redirect:/adminDashboard"; // Redirect to AdminDashboard view
            } else {
            model.addAttribute("error", "Invalid username or password");
            return "AdminLogin"; // Redirect back to login page
        }
	}
	
	@GetMapping("/adminDashboard")
	public String adminDashboard(Model model, HttpSession session) {
	    String userName = (String) session.getAttribute("userName");
	    if (userName == null) {
	        model.addAttribute("error", "You need to log in first");
	        return "AdminLogin"; // Redirect to login if session expired or not logged in
	    }
	    List<CustomerEnquireList> allList = enqService.getAllList();
		
		model.addAttribute("customerEnquireList", allList);
	    model.addAttribute("userName", userName);
	    return "AdminDashboard";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		enqService.deleteEnquire(id);
		return "redirect:/adminDashboard";
	}
	
	 
	@GetMapping("/forgotPassword")
	public String showForgotPasswordForm(Model model) {
		// model.addAttribute("token", null);
		return "ForgotPass";
	}

	@PostMapping("/forgotPassword")
	public String forgotPassword(@RequestParam String username, @RequestParam String email, Model model) {
		System.out.println(username + "And " + email);
		if (emailServiceSender.isUsernameValid(username) && emailServiceSender.isUserEmailValid(email)) {
			emailServiceSender.initiatePasswordReset(username, email);
			model.addAttribute("message", "Password reset link sent to your email.");
		} else {
			model.addAttribute("error", "User not found");
		}
		return "ForgotPass";
	}

	@GetMapping("/resetPassword")
	public String showResetPasswordForm(@RequestParam String token, Model model) {
		model.addAttribute("token", token);
		return "ResetPass";
	}

	@PostMapping("/resetPassword")
	public String resetPassword(@RequestParam String token, @RequestParam String newPassword, Model model) {
		if (emailServiceSender.resetPassword(token, newPassword)) {
			model.addAttribute("message", "Password successfully reset.");
			return "redirect:/adminLogin"; // Redirect to login page
		} else {
			model.addAttribute("error", "Invalid token.");
			return "ResetPass";
		}
	}

	// Handler For About Us Page
	@RequestMapping("/aboutUs")
	public String aboutUsPage() {

		return "AboutUs";
	}

	// Handler For Gallery Page
	@RequestMapping("/gallery")
	public String galleryPage() {

		return "Gallery";
	}

	// Handler For Portfolio Page
	@RequestMapping("/portfolio")
	public String portfolioPage() {

		return "Portfolio";
	}

	// Handler For Events Page
	@RequestMapping("/events")
	public String eventPage() {

		return "Events";
	}

	@GetMapping("/contact")
	public String showContactForm(Model model) {

		CustomerEnquireList customerEnquireList = new CustomerEnquireList();
		model.addAttribute("customerEnquireList", customerEnquireList);
		return "Contact";
	}

	@PostMapping("/save-contact")
	public String submitContactForm(@ModelAttribute CustomerEnquireList customerEnquireList, Model model) {

		// Add here Owner mail id
		emailServiceSender.sendEmail("adiingole1006@gmail.com", "New Inquire Received",
				"You have received a new inquiry from " + customerEnquireList.getName() + ".\n Event Name: "
						+ customerEnquireList.getEvents() + ".\n Event Date" + customerEnquireList.getEventDate()
						+ ".\n Details : " + customerEnquireList.toString());

		// Add Website visitor mail id
		emailServiceSender.sendEmail(customerEnquireList.getEmail(), "Thank you for your inquiry", "Dear "
				+ customerEnquireList.getName()
				+ ",\n Thank you for reaching out. We have received your message and will get back to you soon.");

		enqService.saveEnquireList(customerEnquireList);
		model.addAttribute("successMessage", "Your message has been sent successfully!");

		return "redirect:/contact";

	}

}
