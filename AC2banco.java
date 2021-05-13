package AC2;


import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class AC2banco {

    public static void main(String[] args) {
        String cpf = "1", verificarcpf;
        int menu, opcao = 1, testesenha = 3;
        String senha;
        float deposito, saque;
        double saldo = 1000;

        Locale localeBR = new Locale("pt", "BR");
        NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR); //Formatar Dinheiro

        Scanner ler = new Scanner(System.in);

        System.out.println("Olá, boas vindas!!!");
        System.out.println("");

        System.out.print("Por favor, Digite seu CPF(Somente números): ");
        verificarcpf = ler.nextLine();
        if (cpf.equals(verificarcpf)) {
            do {
                System.out.print("Digite a sua senha: ");
                senha = ler.nextLine();
                if (!"0102".equals(senha)) {
                    System.out.println("Senha INCORRETA!!!");
                    testesenha--;
                    System.out.println("");
                    System.out.println("Tentativas restantes: " + testesenha);
                }
                if (testesenha == 0) {
                    System.out.println("");
                    System.out.println("Tentativas excedidas!!!");
                    System.exit(0);
                }

            } while (!"0102".equals(senha) && testesenha != 0);
            System.out.println("Senha correta!!");
            while (opcao > 0) {

                System.out.println("\nMenu de OPÇÕES"
                        + "\n"
                        + "\n--------------------"
                        + "\no 1 – Saldo"
                        + "\no 2 – Depósito"
                        + "\no 3 – Saque"
                        + "\no 0 – Sair"
                        + "\n--------------------");
                menu = ler.nextInt();

                switch (menu) {   //LOOP do menu
                    case 1:
                        System.out.println("Verificando Saldo."
                                + "\n Aguarde....");
                         {
                            try {
                                TimeUnit.SECONDS.sleep(5);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(AC2banco.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        System.out.println("Seu saldo atual é: " + dinheiro.format(saldo));
                        break;

                    case 2:
                        System.out.println("\nÁrea de depósito");
                        System.out.print("Informe o valor a ser depositado: R$");
                        deposito = ler.nextFloat();
                        saldo = saldo + deposito;
                        System.out.println(" Efetuando operação"
                                + "\n  Aguarde....");

                        try {
                            TimeUnit.SECONDS.sleep(6);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(AC2banco.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("    Operação relaizada com sucesso!!!");
                        System.out.println("     Saldo atualizado: " + dinheiro.format(saldo));
                        break;

                    case 3:
                        System.out.println("\nÁrea de SAQUE");
                        System.out.println("\nVALOR ATUAL: " + dinheiro.format(saldo));
                        System.out.print("Informe o valor a ser sacado: R$");
                        saque = ler.nextFloat();
                        saldo = saldo - saque;
                        System.out.println(" Efetuando operação"
                                + "\n  Aguarde....");

                        try {
                            TimeUnit.SECONDS.sleep(6);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(AC2banco.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("    Operação relaizada com sucesso, retire seu dinheiro!!!");
                        System.out.println("     Saldo atualizado: " + dinheiro.format(saldo));

                        break;
                    case 0:
                        System.out.println("Tem certeza que deseja sair?");
                        System.out.println("1 - SIM"
                                + "\n2 - NÃO");
                        menu = ler.nextInt();

                        if (menu == 1) {
                            System.out.println("Você saiu!");
                            opcao = 0;    //encerramento do LOOP / MENU
                            System.exit(0);
                        }

                        break;
                    default:
                        System.out.println("Opcão inválida!!");
                        throw new AssertionError();
                }

            }
        } else {
            System.out.println("CPF invalido, Tela de acesso não permitido!");
            System.out.println("");
        }
    }

}
