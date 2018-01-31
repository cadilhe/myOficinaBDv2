/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import model.dao.EquipamentoDAO;
import model.domain.Equipamento;

/**
 *
 * @author cadilhe
 */
public class CriaEquipamentos {

    public static void main(String[] args) {

        // Equipamentos          
        System.out.println("Cadastro de equipamentos..");

        // eq1 pertence a c2, possui servicos 1 e 7
        Equipamento eq1 = new Equipamento();
        eq1.setNome("MacBook Air Pro 3000");
        // eq1.setTipo("Notebook");

        Equipamento eq2 = new Equipamento();
        eq2.setNome("Notebook Lenovo Ideapad 320");
        // eq2.setTipo("Notebook");

        // eq3 pertence a c1, possui servicos 8,9,10
        Equipamento eq3 = new Equipamento();
        eq3.setNome("Notebook Samsung Expert X23");
        // eq3.setTipo("Notebook");

        // eq4 pertence a c1, possui servicos 1,2,3 e 4
        Equipamento eq4 = new Equipamento();
        eq4.setNome("Notebook Gamer Acer VX5-591G-78BF");
        // eq4.setTipo("Notebook");

        // eq5 pertence a c2, possui servicos 6
        Equipamento eq5 = new Equipamento();
        eq5.setNome("Notebook Dell Inspiron i15-5566-A30P");
        // eq5.setTipo("Notebook");

        EquipamentoDAO edao = new EquipamentoDAO();
        edao.salvarAtualizar(eq1);
        edao.salvarAtualizar(eq2);
        edao.salvarAtualizar(eq3);
        edao.salvarAtualizar(eq4);
        edao.salvarAtualizar(eq5);
    }
}
