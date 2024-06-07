package DAAII_T1_ALBERTO_GIRON.app_security.service;

import DAAII_T1_ALBERTO_GIRON.app_security.model.bd.Rol;
import DAAII_T1_ALBERTO_GIRON.app_security.model.bd.Usuario;
import DAAII_T1_ALBERTO_GIRON.app_security.repository.RolRepository;
import DAAII_T1_ALBERTO_GIRON.app_security.repository.UsuarioRepository;
import DAAII_T1_ALBERTO_GIRON.app_security.util.RandomPassword;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;



@Service
@AllArgsConstructor
public class UsuarioService implements IUsuarioService{

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private RandomPassword randomPassword;

    @Override
    public Usuario buscarUsuarioXNomUsuario(String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        usuario.setActivo(true);
        Rol usuarioRol = rolRepository.findByNomrol("ADMIN");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        usuario.setPassword(passwordEncoder.encode(randomPassword.generar(7)));
        return usuarioRepository.save(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuarioRepository.actualizarUsuario(
                usuario.getNombres(),usuario.getApellidos(),
                usuario.getActivo(),usuario.getIdusuario());

    }

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarUsuarioXIdUsuario(Integer idusuario) {

        return usuarioRepository.findById(idusuario).orElse(null);
    }
}
