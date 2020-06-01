package otus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import otus.dao.UserRepository;
import otus.model.Role;
import otus.model.User;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String nameUser) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(8);
        User user = userRepository.findByNameUser(nameUser);
        if (user == null) {
            throw new UsernameNotFoundException(nameUser);
        }
        return new org.springframework.security.core.userdetails.User( passwordEncoder.encode(user.getNameUser()),  passwordEncoder.encode(user.getPasswordUser()), getAuthorityList(user.getRole()));
                                                                                                                                                  
    }

    private Set<GrantedAuthority> getAuthorityList(Set<Role> roles) {
        Set<GrantedAuthority> authoritySet = null;

        if(roles != null) {
            authoritySet = roles.stream().map(role -> new SimpleGrantedAuthority(role.getNameRole())).collect(Collectors.toSet());
        } else {
            authoritySet = Collections.<GrantedAuthority>emptySet();
        }

        return authoritySet;
    }

}
