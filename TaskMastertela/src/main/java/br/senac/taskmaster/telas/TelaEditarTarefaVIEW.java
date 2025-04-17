package br.senac.taskmaster.telas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import javax.swing.*;
import java.awt.event.*;
import br.senac.taskmaster.telas.Tarefa; // Certifique-se de que você tem a classe Tarefa importada

public class TelaEditarTarefaVIEW extends javax.swing.JFrame {

    private final Tarefa tarefaSelecionada;
    private final TelaDashboardVIEW dashboard;
    private TelaDashboardVIEW telaDashboard;

    // Construtor
    public TelaEditarTarefaVIEW(Tarefa tarefaSelecionada, TelaDashboardVIEW dashboard) {
        this.tarefaSelecionada = tarefaSelecionada;
        this.dashboard = dashboard;
        initComponents();
        preencherCampos();
    }

    private void preencherCampos() {
        campoTitulo.setText(tarefaSelecionada.getTitulo());  // Agora usa o getTitulo()
        campoDescricao.setText(tarefaSelecionada.getDescricao());
        campoStatus.setSelectedItem(tarefaSelecionada.getStatus());
        campoResponsavel.setText(tarefaSelecionada.getPrazoFormatado());  // Usando o getPrazoFormatado()
    }

    // Método para salvar as alterações feitas na tarefa
    private void salvarAlteracoes() {
        // Atualiza a tarefa com os novos valores dos campos (aqui você pode adicionar a lógica de atualização)
        tarefaSelecionada.setTitulo(campoTitulo.getText());
        tarefaSelecionada.setDescricao(campoDescricao.getText());
        tarefaSelecionada.setStatus((String) campoStatus.getSelectedItem());
        tarefaSelecionada.setPrazo(campoResponsavel.getText());  // Ou usar outro formato para data

        // Após salvar, você pode chamar o método da TelaDashboardVIEW para atualizar a tabela
        if (dashboard != null) {
            dashboard.atualizarTabelaTarefas();  // Atualiza a tabela na TelaDashboardVIEW
        }

        JOptionPane.showMessageDialog(this, "Tarefa atualizada com sucesso!");
        this.dispose();  // Fecha a tela de edição
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoDescricao = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        campoStatus = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        campoCategoria = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        campoResponsavel = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        campoPrazo1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(null);

        jLabel1.setText("Prazo (YYYY-MM-DD):");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 130, 120, 25);

        campoTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTituloActionPerformed(evt);
            }
        });
        getContentPane().add(campoTitulo);
        campoTitulo.setBounds(110, 20, 250, 40);

        jLabel2.setText("Descrição: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 80, 80, 25);

        campoDescricao.setColumns(20);
        campoDescricao.setLineWrap(true);
        campoDescricao.setRows(5);
        campoDescricao.setWrapStyleWord(true);
        campoDescricao.setPreferredSize(new java.awt.Dimension(300, 80));
        jScrollPane1.setViewportView(campoDescricao);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(110, 70, 250, 50);

        jLabel3.setText("Status: ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 170, 80, 25);

        campoStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendente", "Em andamento", "Concluída" }));
        getContentPane().add(campoStatus);
        campoStatus.setBounds(140, 170, 250, 25);

        jLabel5.setText("Categoria:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 200, 80, 25);

        campoCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trabalho", "Pessoal", "Estudos" }));
        getContentPane().add(campoCategoria);
        campoCategoria.setBounds(140, 210, 250, 25);

        jLabel4.setText("Responsável");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 250, 150, 25);
        getContentPane().add(campoResponsavel);
        campoResponsavel.setBounds(140, 130, 240, 25);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(180, 300, 80, 30);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(270, 300, 90, 30);
        getContentPane().add(campoPrazo1);
        campoPrazo1.setBounds(140, 250, 190, 25);

        jLabel6.setText("Título:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 20, 80, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTituloActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            // Atualiza o objeto com os dados dos campos
            tarefaSelecionada.setDescricao(campoDescricao.getText().trim());
            tarefaSelecionada.setStatus((String) campoStatus.getSelectedItem());

            // Verifica se o campo 'responsavel' está sendo preenchido corretamente
            if (campoResponsavel.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "O campo Responsável não pode ser vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            tarefaSelecionada.setResponsavel(campoResponsavel.getText().trim());

            // Tratando a data de prazo
            String prazoTexto = campoResponsavel.getText().trim();
            if (prazoTexto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O campo Prazo não pode ser vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            Date prazoData = formatoData.parse(prazoTexto);
            tarefaSelecionada.setPrazo(prazoData);

            // Atualiza a tarefa no banco de dados usando o TarefaDAO
            new TarefaDAO().atualizarTarefa(tarefaSelecionada);

            // Recarrega a tabela no dashboard
            dashboard.atualizarTabelaTarefas();

            // Exibe mensagem de sucesso
            JOptionPane.showMessageDialog(this, "Tarefa atualizada com sucesso!");
            dispose();  // Fecha a tela de edição
        } catch (Exception e) {
            // Captura qualquer erro durante o processo
            JOptionPane.showMessageDialog(this, "Erro ao atualizar tarefa: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose(); // Fecha a janela
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaEditarTarefaVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEditarTarefaVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEditarTarefaVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEditarTarefaVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> campoCategoria;
    private javax.swing.JTextArea campoDescricao;
    private javax.swing.JTextField campoPrazo1;
    private javax.swing.JTextField campoResponsavel;
    private javax.swing.JComboBox<String> campoStatus;
    private javax.swing.JTextField campoTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
