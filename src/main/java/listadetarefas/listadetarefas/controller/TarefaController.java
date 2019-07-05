package listadetarefas.listadetarefas.controller;

import listadetarefas.listadetarefas.model.Tarefa;
import listadetarefas.listadetarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @GetMapping("/por-categorias/{idCategoria}")
    public List<Tarefa> findByCategoria(@PathVariable(value = "idCategoria") Integer idCategoria) {
        return tarefaService.findByCategoria(idCategoria);
    }

    @GetMapping("/por-usuarios/{idUsuario}")
    public List<Tarefa> findByUsuarios(@PathVariable(value = "idUsuario") Integer idUsuario) {
        return tarefaService.findByUsuarios(idUsuario);
    }

    @GetMapping("/por-data")
    public List<Tarefa> findByUsuarios(@PathParam(value = "dataInicial") String dataInicial, @PathParam("dataFinal") String dataFinal) {
        return tarefaService.findByDataInicialAndDataFinal(dataInicial, dataFinal);
    }
}
