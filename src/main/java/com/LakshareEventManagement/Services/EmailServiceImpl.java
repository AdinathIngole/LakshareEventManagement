package com.LakshareEventManagement.Services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.LakshareEventManagement.Model.Admin;
import com.LakshareEventManagement.Repository.AdminRepository;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private AdminRepository adminRepo;

	// ........................................................................................

	private Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

	private static final Map<String, String> passwordResetRequests = new HashMap<>();

	public boolean authenticate(String username, String password) {
		// Find admin by username
		Optional<Admin> adminOpt = adminRepo.findByUsername(username);

		if (adminOpt.isPresent()) {
			Admin admin = adminOpt.get();
			// Compare the provided password with the stored password
			boolean match = admin.getPassword().equals(password);
			return match;
		} else {
			System.out.println("User not found: " + username);
			return false;
		}
	}

	public boolean isUsernameValid(String username) {
		logger.info("Checking if username exists: {}", username);
		System.out.println("Checking if username exists: " + username);

		boolean present = adminRepo.findByUsername(username).isPresent();
		return present;
	}
	
	public boolean isUserEmailValid(String email) {
		logger.info("Checking if email exists: {}", email);
		System.out.println("Checking if email exists: " + email);

		boolean present = adminRepo.findByEmail(email).isPresent();
		return present;
	}

	public void initiatePasswordReset(String username, String email) {

		String resetToken = UUID.randomUUID().toString();
		System.out.println("Token " + resetToken);
		passwordResetRequests.put(resetToken, username);

		// Send the password reset email
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("Password Reset Request");
		message.setText(
				"To reset your password, please click the following link: http://localhost:8080/resetPassword?token="
						+ resetToken);
		mailSender.send(message);
	}

	public boolean resetPassword(String token, String newPassword) {
		if (passwordResetRequests.containsKey(token)) {
			String username = passwordResetRequests.get(token);

			Optional<Admin> adminOpt = adminRepo.findByUsername(username);
			if (adminOpt.isPresent()) {
				Admin admin = adminOpt.get();
				admin.setPassword(newPassword);
				adminRepo.save(admin);
				passwordResetRequests.remove(token);
				logger.info("Password updated successfully for user: {}", username);
				return true;
			}

		}
		logger.warn("Invalid token or user not found for token: {}", token);
		return false;
	}

	// ........................................................................

	@Override
	public void sendEmail(String to, String subject, String message) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);
		mailSender.send(simpleMailMessage);
		logger.info("Mail sent Successfully .");
	}

}
