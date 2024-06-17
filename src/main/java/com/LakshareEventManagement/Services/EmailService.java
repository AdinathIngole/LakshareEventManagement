package com.LakshareEventManagement.Services;

public interface EmailService {

	void sendEmail(String to, String subject, String message);
	boolean authenticate(String username, String password);
    boolean isUsernameValid(String username);
    void initiatePasswordReset(String username, String email);
    boolean resetPassword(String token, String newPassword);

}
