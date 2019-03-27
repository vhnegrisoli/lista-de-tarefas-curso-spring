package listadetarefas.listadetarefas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String email;

    @JsonIgnore
    @ManyToMany(mappedBy = "usuarios")
    private List<Tarefa> tarefas;
}
