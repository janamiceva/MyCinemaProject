package mk.ukim.finki.wp.mycinema.service;


import mk.ukim.finki.wp.mycinema.model.User;

public interface AuthService {

    User login (String username, String password);

}