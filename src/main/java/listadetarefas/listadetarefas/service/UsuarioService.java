package listadetarefas.listadetarefas.service;

import listadetarefas.listadetarefas.model.Usuario;
import listadetarefas.listadetarefas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    static final ValidationException USUARIO_NAO_ENCONTRADO = new ValidationException("Usuário não encontrado");

    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> buscarTodosOsUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUmUsuario(int id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> USUARIO_NAO_ENCONTRADO);
    }

    public void delete(int id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> USUARIO_NAO_ENCONTRADO);
        usuarioRepository.delete(usuario);
    }

}
