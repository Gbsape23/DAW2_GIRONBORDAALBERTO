package DAAII_T1_ALBERTO_GIRON.app_security.service;

import DAAII_T1_ALBERTO_GIRON.app_security.model.bd.Usuario;

import java.util.List;import java.util.List;

public interface IUsuarioService {

    Usuario buscarUsuarioXNomUsuario(String nomusuario);
    Usuario guardarUsuario(Usuario usuario);
    void actualizarUsuario(Usuario usuario);
    List<Usuario> listarUsuario();
    Usuario buscarUsuarioXIdUsuario(Integer idusuario);
}
