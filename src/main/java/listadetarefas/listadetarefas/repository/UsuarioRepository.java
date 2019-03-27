package listadetarefas.listadetarefas.repository;

import listadetarefas.listadetarefas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
