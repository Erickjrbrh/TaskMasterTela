package br.senac.taskmaster.telas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // Lista em memória (ainda é usada, por compatibilidade)
    private static final List<UsuarioDTO> usuarios = new ArrayList<>();

    // Adicionar novo usuário (salva na lista e no banco)
    public void adicionarUsuario(UsuarioDTO usuario) {
        if (usuario != null) {
            // Adiciona à lista em memória
            usuarios.add(usuario);

            // Insere no banco de dados
            try (Connection conn = ConexaoDAO.conectar()) {
                String sql = "INSERT INTO Usuario (nome, email, senha) VALUES (?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, usuario.getNome());
                stmt.setString(2, usuario.getEmail());
                stmt.setString(3, usuario.getSenha());

                stmt.executeUpdate();
                System.out.println("Usuário cadastrado no banco: " + usuario.getEmail());
            } catch (SQLException e) {
                System.err.println("Erro ao cadastrar usuário no banco: " + e.getMessage());
            }
        }
    }

    // Verifica se o e-mail já existe no banco de dados
    public boolean emailExiste(String email) {
        try (Connection conn = ConexaoDAO.conectar()) {
            String sql = "SELECT COUNT(*) FROM Usuario WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao verificar e-mail: " + e.getMessage());
        }

        return false;
    }

    // Autenticação consultando o banco
    public UsuarioDTO autenticar(String email, String senha) {
        try (Connection conn = ConexaoDAO.conectar()) {
            String sql = "SELECT id, nome FROM Usuario WHERE email = ? AND senha = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                UsuarioDTO usuario = new UsuarioDTO();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(email);
                usuario.setSenha(senha);

                // Também adiciona à lista se quiser manter consistência
                usuarios.add(usuario);

                System.out.println("Usuário autenticado: " + email);
                return usuario;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao autenticar usuário: " + e.getMessage());
        }

        System.out.println("Falha na autenticação para: " + email);
        return null;
    }

    // Editar usuário (apenas na lista por enquanto)
    public boolean editarUsuario(int id, UsuarioDTO usuarioAtualizado) {
        for (int i = 0; i < usuarios.size(); i++) {
            UsuarioDTO usuario = usuarios.get(i);
            if (usuario.getId() == id) {
                usuario.setNome(usuarioAtualizado.getNome());
                usuario.setEmail(usuarioAtualizado.getEmail());
                usuario.setSenha(usuarioAtualizado.getSenha());
                return true;
            }
        }
        return false;
    }

    // Excluir usuário da lista
    public boolean excluirUsuario(int id) {
        return usuarios.removeIf(usuario -> usuario.getId() == id);
    }

    // Buscar por nome (apenas na lista)
    public UsuarioDTO buscarUsuarioPorNome(String nome) {
        for (UsuarioDTO usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                return usuario;
            }
        }
        return null;
    }

    // Buscar por ID (apenas na lista)
    public UsuarioDTO buscarUsuarioPorId(int id) {
        for (UsuarioDTO usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    // Listar todos os usuários da lista (não do banco)
    public List<UsuarioDTO> listarTodosUsuarios() {
        return new ArrayList<>(usuarios); // Retorna cópia para segurança
    }
}
