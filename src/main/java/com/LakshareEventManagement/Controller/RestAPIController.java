/*
 * package com.LakshareEventManagement.Controller;
 * 
 * import java.util.List; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.LakshareEventManagement.Model.CustomerEnquireList; import
 * com.LakshareEventManagement.Services.CustomerEnquireServicesImpl;
 * 
 * import jakarta.servlet.http.HttpSession;
 * 
 * @RestController public class RestAPIController {
 * 
 * @Autowired private CustomerEnquireServicesImpl enqService;
 * 
 * @GetMapping("/api/enquiries") public List<CustomerEnquireList>
 * getAllEnquiries(Model model, HttpSession session) {
 * 
 * 
 * String userName = (String) session.getAttribute("userName"); if (userName ==
 * null) { model.addAttribute("error", "You need to log in first"); return
 * "adminLogin"; // Redirect to login if session expired or not logged in }
 * 
 * return enqService.getAllList(); }
 * 
 * 
 * }
 */