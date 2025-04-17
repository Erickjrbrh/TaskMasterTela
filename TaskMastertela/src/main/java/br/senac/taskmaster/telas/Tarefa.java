package br.senac.taskmaster.telas;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tarefa {

    private int id;
    private String descricao;
    private String status;
    private String responsavel;
    private Date prazo;
    private int usuarioId;

    public Tarefa(int id, String descricao, String status, String responsavel, Date prazo, int usuarioId) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
        this.responsavel = responsavel;
        this.prazo = prazo;
        this.usuarioId = usuarioId;
    }

    // Construtor a partir do DTO
    public Tarefa(TarefaDTO dto) {
        this.id = dto.getId();
        this.descricao = dto.getDescricao();
        this.status = dto.getStatus();
        this.responsavel = dto.getResponsavel();
        this.usuarioId = dto.getUsuarioId();
        setPrazo(dto.getPrazo()); // usa o método com tratamento de exceção
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }

    public void setPrazo(String prazoStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            this.prazo = sdf.parse(prazoStr);
        } catch (Exception e) {
            e.printStackTrace();
            this.prazo = null;
        }
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getTitulo() {
        return descricao;
    }

    public void setTitulo(String titulo) {
        this.descricao = titulo;
    }

    public String getPrazoFormatado() {
        if (prazo == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(prazo);
    }

    public static Tarefa fromDTO(TarefaDTO dto) {
        return new Tarefa(dto);
    }
}
