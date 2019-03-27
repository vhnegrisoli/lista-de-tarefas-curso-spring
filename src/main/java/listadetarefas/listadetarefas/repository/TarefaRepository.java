package listadetarefas.listadetarefas.repository;

import listadetarefas.listadetarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
}
