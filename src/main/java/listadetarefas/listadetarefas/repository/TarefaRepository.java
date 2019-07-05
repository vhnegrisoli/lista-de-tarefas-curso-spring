package listadetarefas.listadetarefas.repository;

import listadetarefas.listadetarefas.model.Categoria;
import listadetarefas.listadetarefas.model.Tarefa;
import listadetarefas.listadetarefas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

    List<Tarefa> findByDataTarefaBetween(LocalDate dataInicial, LocalDate dataFinal);

    List<Tarefa> findByCategoria(Categoria categoria);

    List<Tarefa> findByUsuarios(List<Usuario> usuarios);

}
