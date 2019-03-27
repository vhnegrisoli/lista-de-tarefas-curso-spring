package listadetarefas.listadetarefas.repository;

import listadetarefas.listadetarefas.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
