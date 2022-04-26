package mk.ukim.finki.wp.mycinema.service.impl;

import mk.ukim.finki.wp.mycinema.model.User;
import mk.ukim.finki.wp.mycinema.model.exceptions.InvalidArgumentException;
import mk.ukim.finki.wp.mycinema.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.wp.mycinema.repository.UserRepository;
import mk.ukim.finki.wp.mycinema.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if(username==null || username.isEmpty() || password==null || password.isEmpty())
            throw new InvalidArgumentException();
        return userRepository.findByUsernameAndPassword(username,password).orElseThrow(InvalidUserCredentialsException::new);

    }
}
