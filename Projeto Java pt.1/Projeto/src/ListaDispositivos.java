import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaDispositivos implements DispositivoInteligenteMetodos {
    Scanner scan = new Scanner(System.in);
    List<Eletrodomesticos> lista = new ArrayList<Eletrodomesticos>();
    TratamentoDeErro tratando = new TratamentoDeErro();

    //================================================================================//
    // Adicionar Eletrodomesticos //
    @Override
    public void addDispositivo() {
        boolean loop1 = false;
        boolean loop2 = false;
        boolean loop3 = false;
        String nomeEletro = null;
        String estadoEletro = null;
        double consumoEletro = 0.0;
        int horas = 0;
        int minutos = 0;

        System.out.println("\t**Cadastro de Eletrodomesticos**\n");
        System.out.print("Digite o nome do eletrodomestico -> ");
        nomeEletro = scan.next();
        
        do {
            System.out.print("Digite o estado do eletrodomestico [Ligado|Desligado] -> ");
            try {
                estadoEletro = scan.next();
                tratando.estadoEletrodomestico(estadoEletro);
                loop1 = true;
            } catch (ExceptionsClasse e) {
                System.out.println();
                System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                System.out.println(e.getMessage());
                System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                System.out.println();
            }
        } while (!loop1);
        
        do {
            System.out.print("Digite o consumo do eletrodomestico em watts -> ");
            try {
                consumoEletro = scan.nextDouble();
                loop2 = true;
            } catch (Exception e) {
                System.out.println();
                System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                System.out.println("##A separação da casa decimal deve ser feita com vírgula##");
                System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                System.out.println();
            }
        } while (!loop2);
        
        String horaMinuto = null;
        do {
            System.out.print("Digite o tempo total de uso diario [HH:MM] -> ");
            horaMinuto = scan.next();
            try {
                LocalTime localTime = LocalTime.parse(horaMinuto);
                horas = localTime.getHour();
                minutos = localTime.getMinute();
                loop3 = true;
            } catch (Exception DateTimeParseException) {
                System.out.println();
                System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                System.out.println("##tFormato invalido de hora e minuto. Digite [HH:MM]");
                System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                System.out.println();
            }
        } while (!loop3);

        Eletrodomesticos eletroTemporario = new Eletrodomesticos(nomeEletro, estadoEletro, consumoEletro, horas, minutos);
        lista.add(eletroTemporario);
        System.out.println("Eletrodomestico Adicionado Com Sucesso !");
    }

//=============================================================================================================//
@Override
public void menuRemove() {
    int escolhaRemocaoMenu = 0;
    boolean loop1 = false;
    boolean loop2 = false;
    boolean loop3 = false;
    boolean voltar = false;

    do {
        System.out.println("\t**Menu de remoção de Eletrodomesticos**\n");
        System.out.println("[1] - Remove pelo nome do Eletrodomestico\n"
                + "[2] - Remove pelo gasto do Eletrodomestico diario\n"
                + "[3] - Remove pelo gasto do Eletrodomestico mensal\n"
                + "[4] - voltar ao menu inicial");

        do {
            System.out.println("Digite a sua escolha de remoção -> ");
            try {
                escolhaRemocaoMenu = scan.nextInt();
                tratando.entradaIncorretaMenuRemocao(escolhaRemocaoMenu);
                loop1 = true;
            } catch (ExceptionsClasse e) {
                System.out.println();
                System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                System.out.println(e.getMessage());
                System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                System.out.println();
            }
        } while (loop1 != true);

        switch (escolhaRemocaoMenu) {
            case 1:
                String nomeEletrodomesticoRemove = null;

                System.out.println("Digite o nome do Eletrodomestico que deseja remover -> ");
                nomeEletrodomesticoRemove = scan.next();

                if (analizaObjeto(nomeEletrodomesticoRemove) == true) {
                    removerPeloNome(nomeEletrodomesticoRemove);
                } else if (analizaObjeto(nomeEletrodomesticoRemove) == false) {
                    System.out.println("Eletrodomestico não encontrado !");
                    break;
                }

                System.out.println("Eletrodomestico removido com sucesso !");
                break;

            case 2:
                double consumoMaximoDiarioELetro = 0.0;

                do {
                    System.out.println("Digite o consumo máximo que os eletrodomésticos devem chegar por dia -> ");
                    try {
                        consumoMaximoDiarioELetro = scan.nextDouble();
                        loop2 = true;
                    } catch (Exception e) {
                        System.out.println();
                        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                        System.out.println("##A separação da casa decimal deve ser feita com vírgula##");
                        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                        System.out.println();
                    }
                } while (loop2 =! true);

                removePorLimiteGastoDiario(consumoMaximoDiarioELetro);
                break;

            case 3:
                double consumoMaximoMensalELetro = 0.0;

                do {
                    System.out.println("Digite o consumo máximo que os eletrodomésticos devem chegar por mês -> ");
                    try {
                        consumoMaximoDiarioELetro = scan.nextDouble();
                        loop3 = true;
                    } catch (Exception e) {
                        System.out.println();
                        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                        System.out.println("##A separação da casa decimal deve ser feita com vírgula##");
                        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                        System.out.println();
                    }
                } while (loop3 =! true);

                removePorLimiteGastoMensal(consumoMaximoMensalELetro);
                break;

            case 4:
                voltar = true;
                break;
        }

    } while (voltar != true);

    System.out.println("Voltando...");
}
//========================================================================================================//
//Menu de iteração//
@Override
public void menuIteracao() {
    boolean loop1 = false;
    boolean loop2 = false;
    boolean loop3 = false;
    boolean loop4 = false;
    int escolahIntercao = 0;
    do {
        System.out.println("\t**Menu de Interacao de Eletrodomesticos**\n");
        System.out.println("[1] - Mostrar Eletrodomesticos cadastrados\n"
                + "[2] - Consumo diario Eletrodomesticos\n"
                + "[3] - Consumo mensal Eletrodomesticos\n"
                + "[4] - Desligar todos os Eletrodomesticos\n"
                + "[5] - Ligar todos os Eletrodomesticos\n"
                + "[6] - Consumo diario Eletrodomestico individual\n"
                + "[7] - Atualizar Eletrodomestico\n"
                + "[8] - Desligar por limite de gasto\n"
                + "[9] - Voltar ao menu inicial\n");
        do {
            System.out.println("Digite a sua escolha de interação -> ");
            try {
                escolahIntercao = scan.nextInt();
                tratando.entradaIncorretaMenuIteracao(escolahIntercao);
                loop1 = true;
            } catch (ExceptionsClasse e) {
                System.out.println();
                System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                System.out.println(e.getMessage());
                System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                System.out.println();
            }
        } while (loop1 != true);

        switch (escolahIntercao) {
            case 1:
                imprimeObjetos();
                break;
            case 2:
                calcularConsumoDiario();
                break;
            case 3:
                calcularConsumoMensal();
                break;
            case 4:
                desligarTudo();
                break;
            case 5:
                ligarTudo();
                break;
            case 6:
                String nomeEletrodomesticoGastoIndividual = null;
                do {
                    System.out.println("Digite o nome do Eletrodomestico que deseja saber o consumo individual -> ");
                    nomeEletrodomesticoGastoIndividual = scan.next();
                    if (analizaObjeto(nomeEletrodomesticoGastoIndividual) == true) {
                        calculaDiarioIndividual(nomeEletrodomesticoGastoIndividual);
                        loop3 = true;
                    } else if (analizaObjeto(nomeEletrodomesticoGastoIndividual) == false) {
                        System.out.println("Eletrodomestico não encontrado !");
                    }
                } while (loop3 != true);
                break;
            case 7:
                menuAtualizacao();
                break;

            case 8:
                double consumoMaximoDesligar = 0;
                do {
                    System.out.println("Digite o consumo maximo que os eletrodomesticos devem chegas por dia -> ");
                    try {
                        consumoMaximoDesligar = scan.nextDouble();
                        loop4 = true;
                    } catch (Exception e) {
                        System.out.println();
                        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                        System.out.println("##A separação da casa decimal deve ser feita com vírgula##");
                        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                        System.out.println();
                    }
                } while (loop4 != true);

                desligarPorLimiteGasto(consumoMaximoDesligar);
                break;

            case 9:
                loop2 = true;
                break;
        } 
    } while (loop2 != true); 
    
    System.out.println("Voltando...");
}
//========================================================================================================//
@Override
public void menuAtualizacao() {
    boolean loop1 = false;
    boolean loopFinal = false;
    int escolhaAtualizacao = 0;
    
    System.out.println("\t**Menu de Atualização de Eletrodomesticos**\n");
    System.out.println("[1] - Atualizar nome\n"
            + "[2] - Atualizar estado\n"
            + "[3] - Atualizar consumo\n"
            + "[4] - Atualizar horas ligadas\n");

    do {
        System.out.println("Digite a sua escolha de interação -> ");
        try {
            escolhaAtualizacao = scan.nextInt();
            tratando.entradaIncorretaMenuIteracao(escolhaAtualizacao);
            loop1 = true;
        } catch (ExceptionsClasse e) {
            System.out.println();
            System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
            System.out.println(e.getMessage());
            System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
            System.out.println();
        }

        String nomeEletrodomestioAtualiza = null;
        do {
            System.out.println("Digite o nome do Eletrodomestico que deseja Atualizar -> ");
            nomeEletrodomestioAtualiza = scan.next();
            if (analizaObjeto(nomeEletrodomestioAtualiza) == true) {
                loopFinal = true;
            } else if (analizaObjeto(nomeEletrodomestioAtualiza) == false) {
                System.out.println("Eletrodomestico não encontrado !");
                break;
            }
        } while (!loopFinal);

        switch (escolhaAtualizacao) {
            case 1:
                String nomeAtualizado = null;
                System.out.println("Digite o novo nome do Eletrodomestico -> ");
                nomeAtualizado = scan.next();
                atualizaNome(nomeAtualizado, nomeEletrodomestioAtualiza);
                loopFinal = true;
                break;
            case 2:
                String estadoNovo = null;
                System.out.println("Digite o novo estado do Eletrodomestico -> ");
                do {
                    try {
                        estadoNovo = scan.next();
                        tratando.estadoEletrodomestico(estadoNovo);
                        loopFinal = true;
                    } catch (Exception e) {
                        System.out.println();
                        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                        System.out.println(e.getMessage());
                        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                        System.out.println();
                    }
                } while (!loopFinal);
                atualizaLigadoDesligado(estadoNovo, nomeEletrodomestioAtualiza);
                break;
            case 3:
                double consumoAtualizado = 0;
                do {
                    System.out.println("Digite o novo consumo do Eletrodomestico -> ");
                    try {
                        consumoAtualizado = scan.nextDouble();
                        loopFinal = true;
                    } catch (Exception e) {
                        System.out.println();
                        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                        System.out.println("##A separação da casa decimal deve ser feita com vírgula##");
                        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                        System.out.println();
                    }
                    atualizaConsumo(consumoAtualizado, nomeEletrodomestioAtualiza);
                } while (!loopFinal);
                break;
            case 4:
                String horasAtualizadas = null;
                int horas = 0;
                int minutos = 0;
                do {
                    System.out.println("Digite as novas horas de atividade do Eletrodomestico -> ");
                    try {
                        horasAtualizadas = scan.next();
                        LocalTime localTime = LocalTime.parse(horasAtualizadas);
                        horas = localTime.getHour();
                        minutos = localTime.getMinute();
                        loopFinal = true;
                    } catch (Exception DateTimeParseException) {
                        System.out.println();
                        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                        System.out.println("##Formato invalido de hora e minuto. Digite [HH:MM]");
                        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                        System.out.println();
                    }
                } while (!loopFinal);
                atualizaHora(horas, minutos, nomeEletrodomestioAtualiza);
                break;
            default:
                break;
        }
    } while (!loopFinal);
}

//========================================================================================================//
//Calculos de consumo//
@Override
public void calcularConsumoDiario() {
    // TODO Auto-generated method stub
    double consumodiario = 0;
    for (Eletrodomesticos eletrodomesticos : lista) {
        consumodiario += gastoDiario(eletrodomesticos.horaEletrodomestico, eletrodomesticos.minutoEletrodomestico, eletrodomesticos.consumoEletrodomestico);
    }
    System.out.printf("O consumo Diario de todos os aparelhos foi de -> %.3f kWh\n", consumodiario);
}

@Override
public void calcularConsumoMensal() {
    // TODO Auto-generated method stub
    double consumoMensal = 0;
    for (Eletrodomesticos eletrodomesticos : lista) {
        consumoMensal += gastoDiario(eletrodomesticos.horaEletrodomestico, eletrodomesticos.minutoEletrodomestico, eletrodomesticos.consumoEletrodomestico) * 30;
    }
    System.out.printf("O consumo Diario de todos os aparelhos foi de -> %.3f kWh\n", consumoMensal);
}
//=============================================================================================================//
@Override
public void removerPeloNome(String nomeRemover) {
    // TODO Auto-generated method stub
    for (int i = 0; i < lista.size(); i++) {
        if (lista.get(i).getNomeEletrodomestico().equals(nomeRemover)) {
            lista.remove(i);
        }
    }
}

@Override
public void removePorLimiteGastoDiario(double limiteGastoWatts) {
    // TODO Auto-generated method stub
    for (int i = 0; i < lista.size(); i++) {
        if (gastoDiario(lista.get(i).getHoraEletrodomestico(), lista.get(i).getMinutoEletrodomestico(), lista.get(i).getConsumoEletrodomestico()) > limiteGastoWatts) {
            lista.remove(i);                
        }
    }
}

@Override
public void removePorLimiteGastoMensal(double limiteGastoWatts) {
    // TODO Auto-generated method stub
    for (int i = 0; i < lista.size(); i++) {
        if (gastoDiario(lista.get(i).getHoraEletrodomestico(), lista.get(i).getMinutoEletrodomestico(), lista.get(i).getConsumoEletrodomestico()) * 30 > limiteGastoWatts) {
            lista.remove(i);                
        }
    }
}
//=============================================================================================================//
//Imprimir Objetos;
@Override
public void imprimeObjetos() {
    // TODO Auto-generated method stub
    System.out.println("**Apresentando Todos os Eletrodomesticos**");
    for (Eletrodomesticos eletrodomesticos : lista) {
        System.out.println(eletrodomesticos.toString());
    }
}
//=============================================================================================================//
//Manupular Eletrodomesticos//
@Override
public void desligarPorLimiteGasto(double limiteGastoWatts) {
    // TODO Auto-generated method stub
    for (Eletrodomesticos eletrodomesticos : lista) {
        double gasto = gastoDiario(eletrodomesticos.horaEletrodomestico, eletrodomesticos.minutoEletrodomestico, eletrodomesticos.consumoEletrodomestico);
        if (gasto > limiteGastoWatts) {
            if (eletrodomesticos.estadoEletrodomestico.equals("Ligado")) {
                System.out.println("O eletrodomestico " + eletrodomesticos.nomeEletrodomestico + " ultrapassou o limite e será desligado");
                eletrodomesticos.estadoEletrodomestico = "Desligado";
            } else if (gasto <= limiteGastoWatts) {
                System.out.println("O eletrodomestico " + eletrodomesticos.nomeEletrodomestico + " ultrapassou, mas já se encontra Desligado.");
            }
        }
    }
}

@Override
public void calculaDiarioIndividual(String nomeEletrodomesticoIndividual) {
    // TODO Auto-generated method stub
    double gastoIndividual = 0;
    for (int i = 0; i < lista.size(); i++) {
        if (lista.get(i).getNomeEletrodomestico().equals(nomeEletrodomesticoIndividual)) {
            gastoIndividual = gastoDiario(lista.get(i).getHoraEletrodomestico(), lista.get(i).getMinutoEletrodomestico(), lista.get(i).getConsumoEletrodomestico());
        }
    }
    System.out.printf("O gasto individual do objeto em kWh é -> %.3f\n", gastoIndividual);
}

@Override
public void desligarTudo() {
    // TODO Auto-generated method stub
    for (Eletrodomesticos eletrodomesticos : lista) {
        if (eletrodomesticos.estadoEletrodomestico.equals("Ligado")) {
            eletrodomesticos.estadoEletrodomestico = "Desligado";
            System.out.println("Todos os eletrodomestico foram desligados !");
        }
    }
}

@Override
public void ligarTudo() {
    // TODO Auto-generated method stub
    for (Eletrodomesticos eletrodomesticos : lista) {
        if (eletrodomesticos.estadoEletrodomestico.equals("Desligado")) {
            eletrodomesticos.estadoEletrodomestico = "Ligado";
            System.out.println("Todos os eletrodomesticos foram ligados !");
        }
    }
}

@Override
public void atualizaNome(String nomeNovo, String nomeBusca) {
    // TODO Auto-generated method stub
    for (Eletrodomesticos eletrodomesticos : lista) {
        if (eletrodomesticos.nomeEletrodomestico.equals(nomeBusca)) {
            eletrodomesticos.nomeEletrodomestico = nomeNovo;
            System.out.println("Nome atualizado com sucesso !");
        }
    }
}

@Override
public void atualizaLigadoDesligado(String ligadoDesligadoNovo, String nomeBusca) {
    // TODO Auto-generated method stub
    for (Eletrodomesticos eletrodomesticos : lista) {
        if (eletrodomesticos.nomeEletrodomestico.equals(nomeBusca)) {
            eletrodomesticos.estadoEletrodomestico = ligadoDesligadoNovo;
            System.out.println("Estado atualizado com sucesso !");
        }
    }
}

@Override
public void atualizaConsumo(double consumoNovo, String nomeBusca) {
    // TODO Auto-generated method stub
    for (Eletrodomesticos eletrodomesticos : lista) {
        if (eletrodomesticos.nomeEletrodomestico.equals(nomeBusca)) {
            eletrodomesticos.consumoEletrodomestico = consumoNovo;
            System.out.println("Consumo atualizado com sucesso !");
        }
    }
}

@Override
public void atualizaHora(int horaNovo, int minutoNovo, String nomeBusca) {
    // TODO Auto-generated method stub
    for (Eletrodomesticos eletrodomesticos : lista) {
        if (eletrodomesticos.nomeEletrodomestico.equals(nomeBusca)) {
            eletrodomesticos.minutoEletrodomestico = minutoNovo;
            eletrodomesticos.horaEletrodomestico = horaNovo;
            System.out.println("Hora atualizado com sucesso !");
        }
    }
}
//=============================================================================================================//
//Metodos com retorno//
@Override
public boolean analizaObjeto(String nomeEletrodomestico) {
    // TODO Auto-generated method stub
    for (Eletrodomesticos eletrodomesticos : lista) {
        if (eletrodomesticos.nomeEletrodomestico.equals(nomeEletrodomestico)) {
            return true;
        }
    }
    return false;
}

@Override
public double gastoDiario(int hora, int minuto, double watts) {
    // TODO Auto-generated method stub
    int minutoTotal = 0;
    double gastoWatts;
    minutoTotal = (hora * 60) + minuto;
    gastoWatts = (watts / 1000) * (minutoTotal / 60);

    return gastoWatts;
}
//=============================================================================================================//

  
}