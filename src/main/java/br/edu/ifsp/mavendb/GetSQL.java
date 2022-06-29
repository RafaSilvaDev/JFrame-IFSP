package br.edu.ifsp.mavendb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class GetSQL extends JFrame{

    public void setCidade(String cidade, int populacao){
        txtCidade.setText("Cidade: " + cidade);
        txtPopulacao.setText("População: " + populacao);
    }
    private JPanel panel1;
    private JButton coletarCidadeButton;
    private JLabel txtCidade;
    private JLabel txtPopulacao;

    public GetSQL(){
        setContentPane(panel1);
        setTitle("Minha Interface");
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        coletarCidadeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DAOUser daoUser = new DAOUser();
                setVisible(false);
                daoUser.connect();
                daoUser.updateChar();
                daoUser.select();
                daoUser.disconnect();
            }
        });
    }

    public static void main(String[] args) {
        GetSQL getSQL = new GetSQL();
    }



    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
