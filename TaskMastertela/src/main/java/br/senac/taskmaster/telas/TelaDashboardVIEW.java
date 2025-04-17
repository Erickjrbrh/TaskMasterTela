package br.senac.taskmaster.telas;

import br.senac.taskmaster.telas.TarefaDAO;
import br.senac.taskmaster.telas.TarefaDTO;
import br.senac.taskmaster.telas.UsuarioDTO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaDashboardVIEW extends javax.swing.JFrame {

    private UsuarioDTO usuarioLogado;
    private TarefaDAO tarefaDAO;

    // Construtor que recebe o usuarioLogado
    public TelaDashboardVIEW(UsuarioDTO usuarioLogado) {
        initComponents();
        this.usuarioLogado = usuarioLogado;
        tarefaDAO = new TarefaDAO();
        carregarTabelaTarefas();
    }

    public TelaDashboardVIEW() {
        initComponents(); // ou o método que você usa pra montar os elementos da interface
    }

    private void carregarTabelaTarefas() {
        DefaultTableModel model = (DefaultTableModel) tabelaTarefas.getModel();
        model.setRowCount(0);  // Limpar tabela antes de carregar as tarefas

        // Buscar tarefas do usuário logado
        for (TarefaDTO tarefa : tarefaDAO.listarTarefasPorUsuario(usuarioLogado.getId())) {
            model.addRow(new Object[]{
                tarefa.getId(),
                tarefa.getDescricao(),
                tarefa.getStatus(),
                tarefa.getResponsavel(),
                tarefa.getPrazo()
            });
        }
    }

    public void atualizarTabelaTarefas() {
        TarefaDAO tarefaDAO = new TarefaDAO();
        List<TarefaDTO> listaTarefas = tarefaDAO.listarTarefasPorUsuario(usuarioLogado.getId());

        DefaultTableModel model = (DefaultTableModel) tabelaTarefas.getModel();
        model.setRowCount(0); // Limpa a tabela

        for (TarefaDTO tarefa : listaTarefas) {
            model.addRow(new Object[]{
                tarefa.getId(), // ✅ ADICIONE ISSO
                tarefa.getDescricao(),
                tarefa.getStatus(),
                tarefa.getResponsavel(),
                tarefa.getPrazo()
            });
        }

        // (Opcional) Oculta o ID na visualização
        tabelaTarefas.getColumnModel().getColumn(0).setMinWidth(0);
        tabelaTarefas.getColumnModel().getColumn(0).setMaxWidth(0);
        tabelaTarefas.getColumnModel().getColumn(0).setWidth(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnNovaTarefa = new javax.swing.JButton();
        campoBusca = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        scrollTabela = new javax.swing.JScrollPane();
        tabelaTarefas = new javax.swing.JTable();
        btnAtualizar = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnEditarTarefa = new javax.swing.JButton();
        btnExcluirTarefa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(248, 249, 250));
        setPreferredSize(new java.awt.Dimension(850, 800));
        getContentPane().setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblTitulo.setText("TaskMaster - Dashboard");
        lblTitulo.setPreferredSize(new java.awt.Dimension(300, 30));
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(20, 20, 300, 30);

        btnNovaTarefa.setBackground(new java.awt.Color(0, 123, 255));
        btnNovaTarefa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnNovaTarefa.setForeground(new java.awt.Color(255, 255, 255));
        btnNovaTarefa.setText("Nova Tarefa");
        btnNovaTarefa.setActionCommand("");
        btnNovaTarefa.setPreferredSize(new java.awt.Dimension(120, 30));
        btnNovaTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaTarefaActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovaTarefa);
        btnNovaTarefa.setBounds(650, 60, 120, 30);

        campoBusca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoBusca.setForeground(new java.awt.Color(255, 255, 255));
        campoBusca.setText("Buscar Tarefa");
        campoBusca.setPreferredSize(new java.awt.Dimension(250, 30));
        campoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBuscaActionPerformed(evt);
            }
        });
        getContentPane().add(campoBusca);
        campoBusca.setBounds(20, 70, 250, 30);

        btnBuscar.setBackground(new java.awt.Color(0, 123, 255));
        btnBuscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Pesquisar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(280, 70, 93, 24);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(751, 300));

        scrollTabela.setPreferredSize(new java.awt.Dimension(750, 300));

        tabelaTarefas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Título", "Descrição", "Status", "Prazo"
            }
        ));
        tabelaTarefas.setPreferredSize(new java.awt.Dimension(750, 300));
        scrollTabela.setViewportView(tabelaTarefas);

        jScrollPane2.setViewportView(scrollTabela);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 110, 770, 330);

        btnAtualizar.setBackground(new java.awt.Color(0, 123, 255));
        btnAtualizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnAtualizar.setText("Atualizar Tarefa");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtualizar);
        btnAtualizar.setBounds(490, 60, 140, 24);

        btnLogout.setBackground(new java.awt.Color(255, 0, 51));
        btnLogout.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Sair");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogout);
        btnLogout.setBounds(260, 460, 72, 24);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Copyright © 2025 TaskMaster");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(590, 460, 162, 14);

        btnEditarTarefa.setBackground(new java.awt.Color(0, 123, 255));
        btnEditarTarefa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEditarTarefa.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarTarefa.setText("Editar");
        btnEditarTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTarefaActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditarTarefa);
        btnEditarTarefa.setBounds(30, 460, 72, 24);

        btnExcluirTarefa.setBackground(new java.awt.Color(0, 123, 255));
        btnExcluirTarefa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnExcluirTarefa.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluirTarefa.setText("Excluir");
        btnExcluirTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirTarefaActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluirTarefa);
        btnExcluirTarefa.setBounds(150, 460, 72, 24);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovaTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaTarefaActionPerformed
        TelaNovaTarefaVIEW novaTarefa = new TelaNovaTarefaVIEW(usuarioLogado, this);
        novaTarefa.setVisible(true);
    }//GEN-LAST:event_btnNovaTarefaActionPerformed

    private void btnEditarTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTarefaActionPerformed
        int linhaSelecionada = tabelaTarefas.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int idTarefa = (int) tabelaTarefas.getValueAt(linhaSelecionada, 0);

            TarefaDTO tarefaDTO = tarefaDAO.buscarTarefaPorId(idTarefa);
            Tarefa tarefaSelecionada = new Tarefa(tarefaDTO); // 

            TelaEditarTarefaVIEW editar = new TelaEditarTarefaVIEW(tarefaSelecionada, this);
            editar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa para editar!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarTarefaActionPerformed

    private void btnExcluirTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirTarefaActionPerformed
        int linhaSelecionada = tabelaTarefas.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int idTarefa = (int) tabelaTarefas.getValueAt(linhaSelecionada, 0);
            int resposta = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir esta tarefa?", "Excluir", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                tarefaDAO.excluirTarefa(idTarefa);
                carregarTabelaTarefas(); // Atualizar a tabela
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa para excluir!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirTarefaActionPerformed

    private void campoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBuscaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String descricaoBusca = campoBusca.getText().trim();

        if (!descricaoBusca.isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) tabelaTarefas.getModel();
            model.setRowCount(0);  // Limpar tabela antes de carregar as tarefas

            // Buscar as tarefas filtradas pela descrição e pelo ID do usuário logado
            for (TarefaDTO tarefa : tarefaDAO.buscarTarefasPorDescricao(descricaoBusca, usuarioLogado.getId())) {
                model.addRow(new Object[]{
                    tarefa.getId(),
                    tarefa.getDescricao(),
                    tarefa.getStatus(),
                    tarefa.getResponsavel(),
                    tarefa.getPrazo()
                });
            }
        } else {
            JOptionPane.showMessageDialog(this, "Digite um termo para buscar!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        carregarTabelaTarefas(); // Recarregar as tarefas
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int resposta = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja sair?", "Sair", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            TelaLogin login = new TelaLogin();
            login.setVisible(true);
            this.dispose(); // Fechar a tela atual
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UsuarioDTO usuario = new UsuarioDTO(1, "exemplo@dominio.com", "senha", "Nome de Exemplo");  // Exemplo de usuário logado
                new TelaDashboardVIEW(usuario).setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditarTarefa;
    private javax.swing.JButton btnExcluirTarefa;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNovaTarefa;
    private javax.swing.JTextField campoBusca;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollTabela;
    private javax.swing.JTable tabelaTarefas;
    // End of variables declaration//GEN-END:variables
}
