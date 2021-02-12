package com.lewandowski.service;

import com.lewandowski.entity.Role;
import com.lewandowski.entity.User;
import com.lewandowski.repository.RoleRepository;
import com.lewandowski.repository.UserRepository;
import com.lewandowski.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void save(UserValidator userValidator) {
        User newUser = new User();
        newUser.setUsername(userValidator.getUsername());
        newUser.setPassword(passwordEncoder.encode(userValidator.getPassword()));
        newUser.setEmail(userValidator.getEmail());
        newUser.setPhoneNumber(userValidator.getPhoneNumber());
        newUser.setFirstName(userValidator.getFirstName());
        newUser.setLastName(userValidator.getLastName());
        newUser.setRoles(Collections.singletonList(roleRepository.findRoleByName("ROLE_USER")));

        userRepository.saveOrUpdate(newUser);
    }
}
