package listadetarefas.listadetarefas.model;

import listadetarefas.listadetarefas.enums.TarefaStatusEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    @NotNull
    private String tarefa;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private TarefaStatusEnum status;

    @Column(name = "data_tarefa")
    private LocalDate dataTarefa;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToMany
    @JoinTable(
            name = "usuarios_tarefas",
            joinColumns = @JoinColumn(name = "tarefa_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"))
    private List<Usuario> usuarios;

}
