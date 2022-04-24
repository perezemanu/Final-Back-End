package com.example.integrador.config.auth;



import com.example.integrador.repository.entity.RolesUsuario;
import com.example.integrador.repository.entity.Usuario;
import com.example.integrador.repository.irepository.UsarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UsarioRepository usuarioRepository;

    @Autowired
    public void setUsuarioRepository(UsarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        String password2 = passwordEncoder.encode("password2");

//        usuarioRepository.save(new Usuario("pepe", password, RolesUsuario.ROLE_ADMIN));
//        usuarioRepository.save(new Usuario("majo", password2, RolesUsuario.ROLE_USER));
    }
}
