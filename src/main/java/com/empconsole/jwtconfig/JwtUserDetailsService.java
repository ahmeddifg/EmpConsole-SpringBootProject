package com.empconsole.jwtconfig;


import java.util.List;

import com.empconsole.entities.EmpAccount;
import com.empconsole.exceptions.exceptionTypes.EmailUniqueException;
import com.empconsole.exceptions.exceptionTypes.LoginException;
import com.empconsole.exceptions.exceptionTypes.UserNameUniqueException;
import com.empconsole.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public EmpAccount loadUserByUsername(String username) throws UsernameNotFoundException {
        List<EmpAccount> empList = null;
        if (!username.contains("@"))
            empList = this.userRepository.findByUserName(username);
        else empList = this.userRepository.findByEmail(username);
        if (empList.size() == 0)
            throw new LoginException();

        return empList.get(0);

    }


    public EmpAccount registerNewUser(EmpAccount user) {
        EmpAccount empAccount = null;
        user.setIsActive(1);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            empAccount = this.userRepository.save(user);

        } catch (Exception e) {
            if(e.getMessage().contains("USER_NAME_UNIQUE"))
                throw  new UserNameUniqueException(user.userName);
            else if(e.getMessage().contains("EMAIL_UNIQUE"))
                throw new EmailUniqueException(user.email);
        }
        return empAccount;
    }


    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}