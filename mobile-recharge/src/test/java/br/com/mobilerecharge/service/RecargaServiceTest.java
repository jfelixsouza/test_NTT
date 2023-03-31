package br.com.mobilerecharge.service;

import br.com.mobilerecharge.model.Cliente;
import br.com.mobilerecharge.model.Conta;
import br.com.mobilerecharge.model.Telefone;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class RecargaServiceTest {

    @Test
    public void recargaSucessoTest() {

        Conta conta = new Conta(100);
        Telefone telefone = new Telefone("(11)91257-2449", 5);
        Cliente cliente = new Cliente("Jeferson", telefone, conta);

        RecargaService recargaService = new RecargaService();
        boolean statusRecarga = recargaService.recarga(10, cliente);

        Assert.assertTrue(statusRecarga);
        Assert.assertEquals(90, cliente.getConta().getSaldo());
        Assert.assertEquals(15, cliente.getTelefone().getSaldo());
    }

    @Test
    public void recargaSaldoMenorValorRecargaTest() {

        Conta conta = new Conta(100);
        Telefone telefone = new Telefone("(11)91257-2449", 5);
        Cliente cliente = new Cliente("Jeferson", telefone, conta);

        RecargaService recargaService = new RecargaService();
        boolean statusRecarga = recargaService.recarga(101, cliente);

        Assert.assertFalse(statusRecarga);
        Assert.assertEquals(100, cliente.getConta().getSaldo());
        Assert.assertEquals(5, cliente.getTelefone().getSaldo());
    }
}
