package dao;


import bean.ClienteBean;
import bean.ProdutosBean;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDao {
        
    public void create(ClienteBean c){ //Função para salvar os dados
        Connection con = ConnectionFactory.getConnection(); //Variável que irá receber a conexão
        PreparedStatement stmt = null; //Variável que irá guardar o comando SQL
        
        try {
           stmt = con.prepareStatement("INSERT INTO cliente(n,cep,cpf,cod,telefone,email,nome) VALUES (?,?,?,?,?,?,?)"); //Varável stmt irá receber os comando SQL
            stmt.setString(1, c.getN());
            stmt.setString(2, c.getCep());
            stmt.setString(3, c.getCpf());
            stmt.setInt(4, c.getCod());
            stmt.setString(5, c.getTelefone());
            stmt.setString(6, c.getEmail());
            stmt.setString(7, c.getNome());
           
//Enviar o nome do usuário para o banco
            
            
            stmt.executeUpdate();//Executar o comando
            
            JOptionPane.showMessageDialog(null,"Salvo com Sucesso"); // Exibir mensagem caso tudo funcione
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar" + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void Update(ClienteBean p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE cliente SET n = ?, cep = ?,cpf = ?, telefone = ? , email = ? , nome = ? WHERE cod = ? ");
           
            //stmt.setString(1, p.getNome()); //Enviar o nome do usuário para o banco
            //stmt.setInt(2,p.getQtd()); //Enviar a descrição para o banco
            //stmt.setString(3, p.getForn()); //Enviar...
            //stmt.setDouble(4, p.getPreco());//Enviar...
            //stmt.setString(5, p.getCat());
            //stmt.setInt(6, p.getCod());
            stmt.setString(1, p.getN());
            stmt.setString(2, p.getCep());
            stmt.setString(3, p.getCpf());
            stmt.setString(4, p.getTelefone());
            stmt.setString(5, p.getEmail());
            stmt.setString(6, p.getNome());
            stmt.setInt(7, p.getCod());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Atualizado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Atualizar" + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    
}
    public void delete(ClienteBean p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM cliente WHERE cod = ?");
            stmt.setInt(1, p.getCod());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Excluido com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir" + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}


