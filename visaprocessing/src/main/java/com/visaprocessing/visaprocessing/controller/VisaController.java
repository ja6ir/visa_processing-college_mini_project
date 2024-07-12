package com.visaprocessing.visaprocessing.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.visaprocessing.visaprocessing.entity.AdminUserModel;
import com.visaprocessing.visaprocessing.entity.Apply;
import com.visaprocessing.visaprocessing.entity.Login;
import com.visaprocessing.visaprocessing.entity.Registration;
import com.visaprocessing.visaprocessing.entity.Visa;
import com.visaprocessing.visaprocessing.repository.ApplyRepository;
import com.visaprocessing.visaprocessing.repository.RegistrationRepository;
import com.visaprocessing.visaprocessing.repository.VisaRepository;
import com.visaprocessing.visaprocessing.service.ApplyService;
import com.visaprocessing.visaprocessing.service.LoginService;
import com.visaprocessing.visaprocessing.service.RegistrationService;


import jakarta.servlet.http.HttpSession;

@Controller
public class VisaController { 
	@GetMapping("/")
public String index(){
return "home"; }


@GetMapping("/about.html")
public String about(){
return "about2"; }


@GetMapping("/home.html")
public String home(){
return "home"; }

@GetMapping("/login.html")
public String loginpage(){
return "login"; }

@GetMapping("/lhome.html")
public String lhome(){
return "lhome"; }

@GetMapping("/apply.html")
public String applypage(){
return "apply"; }

@GetMapping("/register.html")
public String registerpage(){
return "register"; }

@Autowired
private RegistrationService regservice;
@Autowired
private LoginService userService;

@PostMapping("/saveuser")
public String saveuser( @ModelAttribute Registration user) {
	regservice.saveuser(user);
	return "redirect:/login.html";
}
@GetMapping("/login")
public ModelAndView login() {
ModelAndView mav = new ModelAndView("login.html");
mav.addObject("user", new Login());
return mav;
}
@PostMapping("/login")
public String login(@ModelAttribute("user") Login user,HttpSession session ) {

Login oauthUser = userService.login(user.getUsername(), user.getPassword());



if(Objects.nonNull(oauthUser)) 
{    
	session.setAttribute("username", user.getUsername());
	session.setAttribute("role", "user");

    return "redirect:/lhome.html";

    
} else {
	System.out.println("username"+ user.getUsername());
    return "redirect:/login.html";

}

}
@Autowired
private ApplyService aService;

@PostMapping("/applyvisa")
public String applyvisa(@ModelAttribute Apply v, HttpSession session) {
    // Get the username from the session
    String username = (String) session.getAttribute("username");

    if (username != null) {
        // Set the username in the Apply entity
        v.setUsername(username);

        // Call the service to save the entity
        aService.applyvisa(v);

        return "redirect:/lhome.html";
    } else {
        // Handle the case where the username is not found in the session (e.g., user not logged in)
        return "redirect:/login.html";
    }
}
@Autowired
private VisaRepository visaRepository;




@GetMapping("/approved.html")
public String getApprovedVisas(HttpSession session, Model model) {
    String username = (String) session.getAttribute("username"); // Retrieve the username from the session

    if (username == null) {
        // Handle the case where the username is not found in the session (e.g., user is not logged in)
        return "redirect:/login"; // Redirect to the login page or handle it as needed
    }

    List<Visa> approvedVisas = visaRepository.findByVisastatusAndUsername("approved", username);
    model.addAttribute("approvedVisas", approvedVisas);

    return "approved"; // This should be the name of your HTML template
}

@GetMapping("/pending.html")
public String getPendingVisas(HttpSession session, Model model) {
    String username = (String) session.getAttribute("username"); // Retrieve the username from the session

    if (username == null) {
        // Handle the case where the username is not found in the session (e.g., user is not logged in)
        return "redirect:/login"; // Redirect to the login page or handle it as needed
    }

    List<Visa> pendingVisas = visaRepository.findByVisastatusAndUsername("pending", username);
    model.addAttribute("pendingVisas", pendingVisas);

    return "pending"; // This should be the name of your HTML template
}

@GetMapping("/rejected.html")
public String getRejectedVisas(HttpSession session, Model model) {
    String username = (String) session.getAttribute("username"); // Retrieve the username from the session

    if (username == null) {
        // Handle the case where the username is not found in the session (e.g., user is not logged in)
        return "redirect:/login"; // Redirect to the login page or handle it as needed
    }

    List<Visa> rejectedVisas = visaRepository.findByVisastatusAndUsername("rejected", username);
    model.addAttribute("rejectedVisas", rejectedVisas);

    return "rejected"; // This should be the name of your HTML template
}


    @Autowired
    private RegistrationRepository registrationRepository; // Assuming you have a repository for Registration
    @Autowired
    private ApplyRepository applyRepository; // Assuming you have a repository for Apply

    @GetMapping("/profile")
    public String showProfile(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username"); // Retrieve the username from the session
        if (username == null) {
            // Handle the case where the username is not found in the session (e.g., user is not logged in)
            return "redirect:/login"; // Redirect to the login page or handle it as needed
        }

        Registration registration = registrationRepository.findByUsername(username);
        

        // Add user data to the model as before


        model.addAttribute("username", registration.getUsername());
        model.addAttribute("fname", registration.getFname());
        model.addAttribute("mname", registration.getMname());
        model.addAttribute("lname", registration.getLname());
        model.addAttribute("email", registration.getEmail());
        model.addAttribute("nationality", registration.getNationality());
        model.addAttribute("passport_number", registration.getPassport_number());
        model.addAttribute("address", registration.getAddress());
        model.addAttribute("zipcode", registration.getZipcode());
        model.addAttribute("mobile", registration.getMobile());
        model.addAttribute("faname", registration.getFaname());
        model.addAttribute("fnationality", registration.getFnationality());
        model.addAttribute("moname", registration.getMoname());
        model.addAttribute("mnationality", registration.getMnationality());
        model.addAttribute("status", registration.getStatus());
      

        return "profile";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.html";
    }
    
    @GetMapping("/contact2")
    public String contact2() {
        
        return "contact2";
    }
    
    //Admin
    
    
    @GetMapping("/admin_login.html")
    public String admin_login(){
    return "admin_login"; }

    
  
        @GetMapping("/admin-panel")
        public String adminPanel(HttpSession session ) {
        	  String adminid = (String) session.getAttribute("username");
              String role = (String) session.getAttribute("role");
              if (adminid!=null &&role.equals("admin")) {
              
                 return "admin-panel";
              } else {
                  // Handle the case where the username is not found in the session (e.g., user not logged in)
                  return "redirect:/admin_login.html";
              }
        	
        }

        @GetMapping("/view-users")
        public String viewUsers(Model model) {
            // Fetch user data for all users and populate the AdminUserModel list
            List<AdminUserModel> users = new ArrayList<>();
            List<Registration> registrations = registrationRepository.findAll();
         
            for (Registration registration : registrations) {
                AdminUserModel adminUser = new AdminUserModel();
                adminUser.setUsername(registration.getUsername());
                adminUser.setFname(registration.getFname());
                adminUser.setFname(registration.getMname());
                adminUser.setLname(registration.getLname());
                adminUser.setEmail(registration.getEmail());
                adminUser.setNationality(registration.getNationality());
                 adminUser.setMobile(registration.getMobile());
                adminUser.setFaname(registration.getFaname());
                 adminUser.setMoname(registration.getMoname());
                adminUser.setAddress(registration.getAddress());
                adminUser.setZipcode(registration.getZipcode());
            
              
				
               //Fetch visa status for this user
               

                users.add(adminUser);
            }

            model.addAttribute("users", users);

            return "view-user"; // Create a separate HTML template for viewing users
        }

        @GetMapping("/view-pending")
        public String viewPendingApplications(Model model) {
            // Fetch pending applications for all users and populate the model
            List<Apply> pendingApplications = applyRepository.findByVisastatus("pending");
            model.addAttribute("pendingApplications", pendingApplications);

            // Create a list to store the registration data for pending applications
            List<Registration> registrationDataList = new ArrayList<>();

            // Retrieve registration data for each pending application
            for (Apply pendingApp : pendingApplications) {
                Registration registration = registrationRepository.findByUsername(pendingApp.getUsername());
                registrationDataList.add(registration);
            }

            model.addAttribute("registrationDataList", registrationDataList);

            return "view-pending"; // Create a separate HTML template for viewing pending applications
        }


        @GetMapping("/view-approved")
        public String viewapprovedApplications(Model model) {
            // Fetch pending applications for all users and populate the model
            List<Apply> approvedApplications = applyRepository.findByVisastatus("approved");
            model.addAttribute("approvedApplications", approvedApplications);

            // Create a list to store the registration data for pending applications
            List<Registration> registrationDataList = new ArrayList<>();

            // Retrieve registration data for each pending application
            for (Apply approvedApp : approvedApplications) {
                Registration registration = registrationRepository.findByUsername(approvedApp.getUsername());
                registrationDataList.add(registration);
            }

            model.addAttribute("registrationDataList", registrationDataList);

            return "view-approved"; // Create a separate HTML template for viewing pending applications
        }

        @GetMapping("/view-rejected")
        public String viewrejectedApplications(Model model) {
            // Fetch pending applications for all users and populate the model
            List<Apply> rejectedApplications = applyRepository.findByVisastatus("rejected");
            model.addAttribute("rejectedApplications", rejectedApplications);

            // Create a list to store the registration data for pending applications
            List<Registration> registrationDataList = new ArrayList<>();

            // Retrieve registration data for each pending application
            for (Apply rejectedApp : rejectedApplications) {
                Registration registration = registrationRepository.findByUsername(rejectedApp.getUsername());
                registrationDataList.add(registration);
            }

            model.addAttribute("registrationDataList", registrationDataList);

            return "view-rejected"; // Create a separate HTML template for viewing pending applications
        }
        @Autowired
        private ApplyService applyService;
        
        @GetMapping("/approveVisa")
        public String approvevisa(@RequestParam ("username") String username,Model model, HttpSession session) {
           // Get the username from the session
           String adminid = (String) session.getAttribute("username");
           String role = (String) session.getAttribute("role");
           if (adminid!=null &&role.equals("admin")) {
           	applyService.setVisaStatusForUser(username, "approved");
              return "redirect:/admin-panel";
           } else {
               // Handle the case where the username is not found in the session (e.g., user not logged in)
               return "redirect:/admin_login.html";
           }
       }
        
        @GetMapping("/rejectVisa")
         public String rejectvisa(@RequestParam ("username") String username,Model model, HttpSession session) {
            // Get the username from the session
            String adminid = (String) session.getAttribute("username");
            String role = (String) session.getAttribute("role");
            if (adminid!=null &&role.equals("admin")) {
            	applyService.setVisaStatusForUser(username, "rejected");
               return "redirect:/admin-panel";
            } else {
                // Handle the case where the username is not found in the session (e.g., user not logged in)
                return "redirect:/admin_login.html";
            }
        }
       

        @PostMapping("/adminlogin")
       public String adminlogin(@ModelAttribute("user") Login user,HttpSession session ) {

            	Login oauthUser = userService.login(user.getUsername(), user.getPassword());
            	String username = user.getUsername();
                     
                     
                     if (Objects.nonNull(oauthUser)) {
                    	    session.setAttribute("username", user.getUsername());
                    	    
                    	    Login user1 = userService.getRoleByUsername(username);
                            String role = user1.getRole();
                    	    
                    	    if (role != null && role.equals("admin")) {
                    	    	 session.setAttribute("role", "admin");
                    	    	 // Redirect to the admin panel because the role is "admin"
                    	        return "redirect:/admin-panel";
                    	    } else {
                    	        // For non-admin users, redirect to their respective pages
                    	        return "redirect:/lhome.html"; // or any other user-specific page
                    	    }
                    	} 
                     
                     else {
                    	    // Handle the case where the user is not authenticated
                    	    return "redirect:/admin_login.html"; // or any other login page
                    	}
        }

        @GetMapping("/adminlogout")
        public String adminlogout(HttpSession session) {
            session.invalidate();
            return "redirect:/admin_login.html";
        }

        }





       

 

    

    




