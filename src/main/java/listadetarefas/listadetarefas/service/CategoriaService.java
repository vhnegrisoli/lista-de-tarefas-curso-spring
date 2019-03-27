package listadetarefas.listadetarefas.service;

import listadetarefas.listadetarefas.model.Categoria;
import listadetarefas.listadetarefas.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void save(Categoria Categoria) {
        categoriaRepository.save(Categoria);
    }

    public List<Categoria> buscarTodasAsCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarUmCategoria(int id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Tarefa não encontrada."));
    }

    public void delete(Categoria Categoria) {
        categoriaRepository.delete(Categoria);
    }

}
