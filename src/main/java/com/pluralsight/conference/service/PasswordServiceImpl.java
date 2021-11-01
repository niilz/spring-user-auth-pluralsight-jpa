package com.pluralsight.conference.service;

import com.pluralsight.conference.model.Password;
import com.pluralsight.conference.model.ResetToken;
import com.pluralsight.conference.repository.PasswordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {

	@Autowired
	private PasswordRepository passwordRepository;

	@Override
	public void createResetToken(Password password, String token) {
		var resetToken = new ResetToken();
		resetToken.setToken(token);
		resetToken.setEmail(password.getEmail());
		resetToken.setUsername(password.getUsername());
		resetToken.setExpiryDate(resetToken.calculateExpiryDate(ResetToken.EXPIRATION));

		passwordRepository.save(resetToken);
		
	}


	@Override
	public void update(Password password, String username) {
		//passwordRepository.update(password, username);
	}


	@Override
	public boolean confirmResetToken(ResetToken resetToken) {
		// TODO Auto-generated method stub
		return false;
	}

}
