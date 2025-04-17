package br.senac.taskmaster.telas;

public class TarefaDTO {

    private int id;
    private String titulo;         // ✅ Campo adicional: título
    private String descricao;
    private String status;
    private String responsavel;
    private String prazo;
    private int usuarioId;

    // ✅ Construtores
    private int categoriaId; // ✅ Novo campo

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    // Construtor completo com título
    public TarefaDTO(int id, String titulo, String descricao, String status, String responsavel, String prazo, int usuarioId) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.responsavel = responsavel;
        this.prazo = prazo;
        this.usuarioId = usuarioId;
    }

    // Construtor sem título, com usuário
    public TarefaDTO(int id, String descricao, String status, String responsavel, String prazo, int usuarioId) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
        this.responsavel = responsavel;
        this.prazo = prazo;
        this.usuarioId = usuarioId;
    }

    // Construtor original (compatibilidade)
    public TarefaDTO(int id, String descricao, String status, String responsavel, String prazo) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
        this.responsavel = responsavel;
        this.prazo = prazo;
    }

    // Construtor vazio
    public TarefaDTO() {
    }

    // ✅ Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    // ✅ Conversão de entidade Tarefa para DTO
    public static TarefaDTO fromEntity(Tarefa tarefa) {
        String prazoStr = "";
        try {
            prazoStr = tarefa.getPrazoFormatado(); // ex: "dd/MM/yyyy"
        } catch (Exception e) {
            e.printStackTrace();
        }

        TarefaDTO dto = new TarefaDTO();
        dto.setId(tarefa.getId());
        dto.setTitulo(tarefa.getTitulo());
        dto.setDescricao(tarefa.getDescricao());
        dto.setStatus(tarefa.getStatus());
        dto.setResponsavel(tarefa.getResponsavel());
        dto.setPrazo(prazoStr);
        dto.setUsuarioId(tarefa.getUsuarioId());
        return dto;
    }
}
