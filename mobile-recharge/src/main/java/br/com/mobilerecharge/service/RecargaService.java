package br.com.mobilerecharge.service;

import br.com.mobilerecharge.model.Cliente;

public class RecargaService {

    public boolean recarga(int vlRecarga, Cliente cliente) {

        // Verifica se o cliente possui saldo suficiente para recarga
        if(cliente.getConta().getSaldo() < vlRecarga)
            return false;

        // Atualiza saldo conta
        cliente.getConta().setRecarga(vlRecarga);
        cliente.getConta().setSaldo(cliente.getConta().getSaldo() - cliente.getConta().getRecarga());

        // Atualiza saldo de creditos telefone
        cliente.getTelefone().setSaldo(cliente.getTelefone().getSaldo() + vlRecarga);

        return true;
    }
}
