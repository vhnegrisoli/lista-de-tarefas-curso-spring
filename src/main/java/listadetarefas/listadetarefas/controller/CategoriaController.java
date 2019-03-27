package listadetarefas.listadetarefas.controller;

import listadetarefas.listadetarefas.model.Categoria;
import listadetarefas.listadetarefas.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/todas")
    public List<Categoria> findAll() {
        return categoriaService.buscarTodasAsCategorias();
    }

    @GetMapping("/buscar/{id}")
    public Categoria findCategoria(@PathVariable int id) {
        return categoriaService.buscarUmaCategoria(id);
    }

    @PostMapping("/salvar")
    public void salvarCategoria(@RequestBody Categoria categoria) {
        categoriaService.save(categoria);
    }

    @GetMapping("/delete/{id}")
    public void deleteCategoria(@PathVariable int id) {
        categoriaService.delete(id);
    }
}
