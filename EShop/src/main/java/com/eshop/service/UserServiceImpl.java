package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eshop.entity.ConfirmationToken;
import com.eshop.entity.Role;
import com.eshop.entity.User;
import com.eshop.repository.ConfirmationTokenRepository;
import com.eshop.repository.RoleRepository;
import com.eshop.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userDAO;
	@Autowired
	private RoleRepository roleDAO;
	@Autowired
	private ConfirmationTokenRepository confirmationTokenDAO;
	@Autowired
	private EmailSenderService emailSenderService;
	private PasswordEncoder pasEnc=new BCryptPasswordEncoder();
	@Override
	public List<User> findAllUsers() {
		return userDAO.findAll();
	}

	@Override
	public void save(User user) {
		User existingUser = userDAO.findByEmailIgnoreCase(user.getEmail());
		if (existingUser != null || userDAO.existsByUsername(user.getUsername())) {
			throw new RuntimeException("User already exist");
		} else {
			user.getRoles().add(roleDAO.getOne(1));
			user.setPassword(pasEnc.encode(user.getPassword()));
			userDAO.save(user);
			ConfirmationToken confirmationToken = new ConfirmationToken(user);

			confirmationTokenDAO.save(confirmationToken);

			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(user.getEmail());
			mailMessage.setSubject("Complete Registration!");
			mailMessage.setFrom("adnan.krdzalic93@gmail.com");
			mailMessage.setText("To confirm your account, please click here : "
					+ "http://localhost:8081/users/confirm-account?token=" + confirmationToken.getConfirmationToken());

			emailSenderService.sendEmail(mailMessage);

			
		}

	}
	
	@Override
	public User getById(int id) {
		return userDAO.getOne(id);
	}

	@Override
	public String confirmationToken(String confirmationToken) {
		ConfirmationToken token = confirmationTokenDAO.findByConfirmationToken(confirmationToken);
		if(token != null){
			
            User user = userDAO.findByEmailIgnoreCase(token.getUser().getEmail());
            user.setIsEnabled(true);
            userDAO.save(user);
		return "Account verified";
		}else {
			return "Link is invalid or broken";
		}
	}
	
}
