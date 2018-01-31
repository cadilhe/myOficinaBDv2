package app;

import java.util.List;
import model.dao.ClienteDAO;
import model.domain.Cliente;

/**
 *
 * @author cadilhe
 */

public class CriaClientes {

    public static void main(String[] args) {

        // cria objetos cliente
        System.out.println("Criando objetos da Entidade Cliente...");

        Cliente c1 = new Cliente();
        c1.setNome("Thomas Cavendish");
        //c1.setCpfcnpj("952.625.180-60");
//        c1.setEmail("thomas.cavendish@gmail.com");
//        c1.setTelefone("(12)992132616");

        Cliente c2 = new Cliente();
        c2.setNome("Thaisa de Araujo de Souza Ramos");
        //c2.setCpfcnpj("247.705.090-73");
//        c2.setEmail("lázaro.ramos@gmail.com");
//        c2.setTelefone("(21)989872323");

        Cliente c3 = new Cliente();
        c3.setNome("Camila Pitanga");
        //c3.setCpfcnpj("314.986.620-05");
//        c3.setEmail("camila.pitanga@gmail.com");
//        c3.setTelefone("(24)238963011");

        // Cria objeto ClienteDAO
        ClienteDAO cdao = new ClienteDAO();
//        cdao.salvar(c1);
//        cdao.salvar(c2);
//        cdao.salvar(c3);
        
        // Lista Objetos
        List<Cliente> clientes = cdao.findAll();
        
        for(Cliente cliente : clientes) {
            System.out.println(cliente.getId() + " - " + cliente.getNome());
        }

    }
}
