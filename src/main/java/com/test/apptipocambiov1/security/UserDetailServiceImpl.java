package com.test.apptipocambiov1.security;

import com.test.apptipocambiov1.entity.UsuarioEntity;
import com.test.apptipocambiov1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuarioEntity = usuarioRepository
                .findOneByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("El usuario no existe"));
        return new UserDetailsImpl(usuarioEntity);

    }
}
