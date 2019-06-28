package listadetarefas.listadetarefas.controller;

import listadetarefas.listadetarefas.model.Tarefa;
import listadetarefas.listadetarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping("/todas")
    public List<Tarefa> findAll() {
        return tarefaService.buscarTodasAsTarefas();
    }

    @GetMapping("/buscar/{id}")
    public Tarefa findTarefa(@PathVariable int id) {
        return tarefaService.buscarUmaTarefa(id);
    }

    @PostMapping("/salvar")
    public void salvarTarefa(@RequestBody Tarefa tarefa) {
        tarefaService.save(tarefa);
    }

    @GetMapping("/fazer/{id}")
    public void fazerTarefa(@PathVariable int id) {
        tarefaService.alterarStatusFazendoTarefa(id);
    }

    @GetMapping("/finalizar/{id}")
    public void finalizarTarefa(@PathVariable int id) {
        tarefaService.finalizarTarefa(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteTarefa(@PathVariable int id) {
        tarefaService.delete(id);
    }
}
