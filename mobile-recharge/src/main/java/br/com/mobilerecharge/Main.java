package br.com.mobilerecharge;

import br.com.mobilerecharge.model.Cliente;
import br.com.mobilerecharge.model.Conta;
import br.com.mobilerecharge.model.Telefone;
import br.com.mobilerecharge.service.RecargaService;

public class Main {

    public static void main(String[] args) {

        Conta conta = new Conta(100);
        Telefone telefone = new Telefone("(11)912572449", 5);
        Cliente cliente = new Cliente("Jeferson", telefone, conta);

        RecargaService recargaService = new RecargaService();
        boolean statusRecarga = recargaService.recarga(10, cliente);

        if(statusRecarga)
            System.out.println("Recarga realizada com sucesso, saldo telefone atual: ".concat(String.valueOf(cliente.getTelefone().getSaldo())));
        else
            System.out.println("Não foi possível realizar a recarga, verifique seu saldo em conta.");
    }
}