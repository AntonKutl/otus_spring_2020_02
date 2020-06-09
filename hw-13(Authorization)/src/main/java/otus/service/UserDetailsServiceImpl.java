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
import otus.model.User;

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
        System.out.println(user.getRole());
        UserDetails userDetails= org.springframework.security.core.userdetails.User.builder()
                .username(user.getNameUser())
                .password(user.getPasswordUser())
                .roles((user.getRole()))
                .build();
        return userDetails;
                                                                                                                                                  
    }
}
