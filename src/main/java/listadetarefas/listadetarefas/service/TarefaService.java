package listadetarefas.listadetarefas.service;

import listadetarefas.listadetarefas.enums.TarefaStatusEnum;
import listadetarefas.listadetarefas.model.Tarefa;
import listadetarefas.listadetarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.validation.ValidationException;
import java.time.LocalDate;
import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    static final ValidationException TAREFA_NAO_ENCONTRADA = new ValidationException("Tarefa não encontrada");

    public void save(Tarefa tarefa) {
        if (isNovaTarefa(tarefa)) {
            tarefa.setStatus(TarefaStatusEnum.ABERTA);
            tarefa.setDataTarefa(LocalDate.now());
        }
        tarefa.setUltimaAtualizacao(LocalDate.now());
        tarefaRepository.save(tarefa);
    }

    public void alterarStatusFazendoTarefa(int id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> TAREFA_NAO_ENCONTRADA);
        if (!isNovaTarefa(tarefa)) {
            tarefa.setStatus(TarefaStatusEnum.FAZENDO);
            tarefa.setUltimaAtualizacao(LocalDate.now());
        }
        tarefaRepository.save(tarefa);
    }

    public void finalizarTarefa(int id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> TAREFA_NAO_ENCONTRADA);
        if (!isNovaTarefa(tarefa)) {
            tarefa.setStatus(TarefaStatusEnum.FINALIZADA);
            tarefa.setUltimaAtualizacao(LocalDate.now());
        }
        tarefaRepository.save(tarefa);
    }

    public boolean isNovaTarefa(Tarefa tarefa) {
        return ObjectUtils.isEmpty(tarefa.getId());
    }

    public List<Tarefa> buscarTodasAsTarefas() {
        return tarefaRepository.findAll();
    }

    public Tarefa buscarUmaTarefa(int id) {
        return tarefaRepository.findById(id)
            .orElseThrow(() -> TAREFA_NAO_ENCONTRADA);
    }

    public void delete(int id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> TAREFA_NAO_ENCONTRADA);
        tarefaRepository.delete(tarefa);
    }

}
