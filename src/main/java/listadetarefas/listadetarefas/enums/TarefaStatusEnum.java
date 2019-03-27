package listadetarefas.listadetarefas.enums;

public enum TarefaStatusEnum {

    ABERTA("Aberta"),
    FAZENDO("Fazendo"),
    FINALIZADA("Finalizada");

    private String status;

    TarefaStatusEnum(String status) {
        this.status =status;
    }

}
