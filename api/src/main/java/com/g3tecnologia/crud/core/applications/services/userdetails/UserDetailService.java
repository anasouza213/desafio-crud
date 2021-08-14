package com.g3tecnologia.crud.core.applications.services.userdetails;


import com.g3tecnologia.crud.core.domain.business.users.UserModel;
import com.g3tecnologia.crud.core.infrastructure.repositories.users.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired(required = true)
    private IUserRepository _userRepository;

    private BCryptPasswordEncoder _bCryptPasswordEncoder;

    @Autowired(required = true)
    public UserDetailService(
            BCryptPasswordEncoder bCryptPasswordEncoder,
            IUserRepository userRepository){
        _userRepository = userRepository;
        _bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel userFound = _userRepository.findByCpf(username);

        if(userFound == null)
        {
            throw new UsernameNotFoundException(username);
        }

        return new UserDetail(userFound);
    }
}

