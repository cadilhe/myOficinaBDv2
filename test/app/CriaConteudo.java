/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import model.dao.EquipamentoDAO;
import java.util.List;
import model.dao.ClienteDAO;
import model.domain.Cliente;
import model.domain.Equipamento;

/**
 *
 * @author cadilhe
 */

public class CriaConteudo {

    public static void main(String[] args) {

        // SERVIÇOS
        System.out.println("Criando Clientes...");
        
        // cria objetos cliente
       // Cria objeto ClienteDAO
        ClienteDAO cdao = new ClienteDAO();

        Cliente c1 = new Cliente();
        c1.setNome("Thomas Cavendish");

        Cliente c2 = new Cliente();
        c2.setNome("Thaisa de Araujo de Souza Ramos");

        Cliente c3 = new Cliente();
        c3.setNome("Camila Pitanga");

              
        // Lista Objetos
        List<Cliente> clientes = cdao.findAll();
        
        clientes.forEach((cliente) -> {
            System.out.println(cliente.getId() + " - " + cliente.getNome());
        });

        // EQUIPAMENTOS
        System.out.println("Associando equipamentos a proprietários...");
        
        EquipamentoDAO edao = new EquipamentoDAO();
        
        Equipamento eq1 = new Equipamento();
        eq1.setNome("MacBook Air Pro");
        eq1.setCliente(c2);
        
        Equipamento eq2 = new Equipamento();
        eq2.setNome("Notebook Lenovo Ideapad 320");
        eq2.setCliente(c3);

        Equipamento eq3 = new Equipamento();
        eq3.setNome("Notebook Samsung Expert X23");
        eq3.setCliente(c3);

        Equipamento eq4 = new Equipamento();
        eq4.setNome("Notebook Gamer Acer VX5-591G-78BF");
        eq4.setCliente(c1);
        
        
        Equipamento eq5 = new Equipamento();
        eq5.setNome("Notebook Dell Inspiron i15-5566-A30P");
        eq5.setCliente(c2);
        

        edao.salvarAtualizar(eq1); 
        edao.salvarAtualizar(eq2); 
        edao.salvarAtualizar(eq3); 
        edao.salvarAtualizar(eq4); 
        edao.salvarAtualizar(eq5);
        
        System.out.println("Lista:");
        
        List<Equipamento> equipamentos = edao.findAll();
        
        System.out.println("Listagem: Código - Equipamento"
                + "---------------------");
        
        equipamentos.forEach((equipamento) -> {
            System.out.println(":: " + equipamento.getId() + "-" + equipamento.getNome()
                    + "Cliente: " + equipamento.getCliente().getNome());
        });
    }
}
