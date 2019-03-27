package listadetarefas.listadetarefas.controller;

import listadetarefas.listadetarefas.model.Usuario;
import listadetarefas.listadetarefas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/todos")
    public List<Usuario> findAll() {
        return usuarioService.buscarTodosOsUsuarios();
    }

    @GetMapping("/buscar/{id}")
    public Usuario findUsuario(@PathVariable int id) {
        return usuarioService.buscarUmUsuario(id);
    }

    @PostMapping("/salvar")
    public void salvarUsuario(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
    }

    @GetMapping("/delete/{id}")
    public void deleteUsuario(@PathVariable int id) {
        usuarioService.delete(id);
    }
}
