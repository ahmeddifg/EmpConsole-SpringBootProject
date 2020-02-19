package com.empconsole.controller;

import com.empconsole.entities.EmpAccount;
import com.empconsole.exceptions.exceptionTypes.LoginExceptionException;
import com.empconsole.jwtconfig.JwtRequest;
import com.empconsole.jwtconfig.JwtResponse;
import com.empconsole.jwtconfig.JwtTokenUtil;
import com.empconsole.jwtconfig.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountLockedException;

@RestController
@RequestMapping("user")
public class UserController {
    private JwtUserDetailsService jwtUserDetailsService;
    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;

    ///////////////////////Constructor//////////////////////////////
    @Autowired
    public UserController(JwtUserDetailsService empAccountService, AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.jwtUserDetailsService = empAccountService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }
///////////////////////////////////////////////////////////////

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody JwtRequest jwtRequest) throws Exception {
        authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());

        final UserDetails userDetails = jwtUserDetailsService
                .loadUserByUsername(jwtRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody EmpAccount empAccount) {
        return ResponseEntity.ok(this.jwtUserDetailsService.registerNewUser(empAccount));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new LoginExceptionException();
        }
    }
//////////////////sets and gets/////////////////////////////

    public JwtUserDetailsService getEmpAccountService() {
        return jwtUserDetailsService;
    }

    public void setEmpAccountService(JwtUserDetailsService jwtUserDetailsService) {
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public JwtTokenUtil getJwtTokenUtil() {
        return jwtTokenUtil;
    }

    public void setJwtTokenUtil(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }
}
