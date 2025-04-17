package br.senac.taskmaster.telas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TarefaDAO {

    // Banco de dados em memória (opcional)
    private static final List<TarefaDTO> listaTarefas = new ArrayList<>();

    public List<TarefaDTO> listarTarefasPorUsuario(int usuarioId) {
        List<TarefaDTO> tarefasUsuario = new ArrayList<>();
        String sql = "SELECT * FROM Tarefa WHERE usuario_id = ?";

        try (Connection conn = new ConexaoDAO().conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                TarefaDTO tarefa = new TarefaDTO();
                tarefa.setId(rs.getInt("id"));
                tarefa.setTitulo(rs.getString("titulo"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setStatus(rs.getString("status"));
                tarefa.setPrazo(rs.getDate("prazo").toString());
                tarefa.setUsuarioId(rs.getInt("usuario_id"));
                tarefasUsuario.add(tarefa);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tarefasUsuario;
    }

    public boolean adicionarTarefa(TarefaDTO tarefa, int usuarioId) {
        tarefa.setUsuarioId(usuarioId); // ainda mantém na lista em memória
        listaTarefas.add(tarefa); // opcional, pode remover se quiser apenas no banco

        String sql = "CALL AdicionarTarefa(?, ?, ?, ?, ?, ?)";

        try (Connection conn = new ConexaoDAO().conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Formatar data para java.sql.Date
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date dataFormatada = formato.parse(tarefa.getPrazo());
            java.sql.Date dataSQL = new java.sql.Date(dataFormatada.getTime());

            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getStatus());
            stmt.setDate(4, dataSQL);
            stmt.setInt(5, usuarioId);
            stmt.setNull(6, java.sql.Types.INTEGER); // categoria_id como NULL

            stmt.execute();
            return true;

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void excluirTarefa(int id) {
        listaTarefas.removeIf(t -> t.getId() == id);
        String sql = "DELETE FROM Tarefa WHERE id = ?";

        try (Connection conn = new ConexaoDAO().conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TarefaDTO buscarTarefaPorId(int id) {
        String sql = "SELECT * FROM Tarefa WHERE id = ?";
        try (Connection conn = new ConexaoDAO().conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                TarefaDTO tarefa = new TarefaDTO();
                tarefa.setId(rs.getInt("id"));
                tarefa.setTitulo(rs.getString("titulo"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setStatus(rs.getString("status"));
                tarefa.setPrazo(rs.getDate("prazo").toString());
                tarefa.setUsuarioId(rs.getInt("usuario_id"));
                return tarefa;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void atualizarTarefa(Tarefa tarefaAtualizada) {
        String sql = "UPDATE Tarefa SET descricao = ?, status = ?, prazo = ? WHERE id = ?";

        try (Connection conn = new ConexaoDAO().conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tarefaAtualizada.getDescricao());
            stmt.setString(2, tarefaAtualizada.getStatus());
            stmt.setDate(3, java.sql.Date.valueOf(tarefaAtualizada.getPrazo().toString()));
            stmt.setInt(4, tarefaAtualizada.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Atualiza também na lista em memória (opcional)
        for (int i = 0; i < listaTarefas.size(); i++) {
            TarefaDTO tarefa = listaTarefas.get(i);
            if (tarefa.getId() == tarefaAtualizada.getId()) {
                tarefa.setDescricao(tarefaAtualizada.getDescricao());
                tarefa.setStatus(tarefaAtualizada.getStatus());
                tarefa.setResponsavel(tarefaAtualizada.getResponsavel());
                tarefa.setPrazo(tarefaAtualizada.getPrazo().toString());
                break;
            }
        }
    }

    public List<TarefaDTO> buscarTarefasPorDescricao(String descricao, int usuarioId) {
        List<TarefaDTO> resultados = new ArrayList<>();
        String sql = "SELECT * FROM Tarefa WHERE usuario_id = ? AND descricao LIKE ?";

        try (Connection conn = new ConexaoDAO().conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            stmt.setString(2, "%" + descricao + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                TarefaDTO tarefa = new TarefaDTO();
                tarefa.setId(rs.getInt("id"));
                tarefa.setTitulo(rs.getString("titulo"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setStatus(rs.getString("status"));
                tarefa.setPrazo(rs.getDate("prazo").toString());
                tarefa.setUsuarioId(rs.getInt("usuario_id"));
                resultados.add(tarefa);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultados;
    }
}
