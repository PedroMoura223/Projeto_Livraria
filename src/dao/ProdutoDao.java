package dao;


import bean.ProdutoBean;
import bean.ProdutosBean;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProdutoDao {
        
    public void create(ProdutoBean p){ //Função para salvar os dados
        Connection con = ConnectionFactory.getConnection(); //Variável que irá receber a conexão
        PreparedStatement stmt = null; //Variável que irá guardar o comando SQL
        
        try {
            stmt = con.prepareStatement("INSERT INTO produto(codigo,cliente,preco,produto) VALUES (?,?,?,?)"); //Varável stmt irá receber os comando SQL
            stmt.setInt(1, p.getCod());
            stmt.setString(2, p.getCliente()); //Enviar o nome do usuário para o banco
            stmt.setString(3,p.getPreco()); //Enviar a descrição para o banco
            stmt.setString(4, p.getProduto()); //Enviar...
           
            
            stmt.executeUpdate();//Executar o comando
            
            JOptionPane.showMessageDialog(null,"Salvo com Sucesso"); // Exibir mensagem caso tudo funcione
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar" + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void Update(ProdutosBean p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE produtos SET nome = ?, qtd = ?,forn = ?,preco = ?, cat = ? WHERE cod = ? ");
            /*stmt.setString(1, p.getNome()); //Enviar o nome do usuário para o banco
            stmt.setInt(2,p.getQtd()); //Enviar a descrição para o banco
            stmt.setString(3, p.getForn()); //Enviar...
            stmt.setDouble(4, p.getPreco());//Enviar...
            stmt.setString(5, p.getCat());
            stmt.setInt(6, p.getCod());*/
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Atualizado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Atualizar" + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    
}
    public void delete(ProdutosBean p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM produtos WHERE cod = ?");
           // stmt.setInt(1, p.getCod());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Excluido com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir" + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}


