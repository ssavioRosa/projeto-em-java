public class TratamentoDeErro {

  
    public void entradaIncorretaMenu1(int escolhaMenu1) throws ExceptionsClasse{
        if (escolhaMenu1 < 1 || escolhaMenu1 > 4) {
            throw new ExceptionsClasse("##Digite um numero inteiro de 1 à 4##\n");
        }
    }
    public void semDadosPalavra(String palavra) throws ExceptionsClasse{
        if(palavra.equals("")){
            throw new ExceptionsClasse("##A entrada de dados é obrigatoria##");
        }

    }
    public void estadoEletrodomestico(String estadoEle) throws ExceptionsClasse {
        if (!(estadoEle.equals("Ligado") || estadoEle.equals("Desligado"))) {
            throw new ExceptionsClasse("##Eletrodomestico deve estar [Ligado] ou [Desligado]##");
        }
    }
     public void entradaIncorretaMenuRemocao(int escolhaMenuRemocao) throws ExceptionsClasse{
        if (escolhaMenuRemocao < 1 || escolhaMenuRemocao > 4) {
            throw new ExceptionsClasse("##Digite um numero inteiro de 1 à 3##\n");
        }
    }
    public void entradaIncorretaMenuIteracao(int escolhaMenuRemocao) throws ExceptionsClasse{
        if (escolhaMenuRemocao < 1 || escolhaMenuRemocao > 8) {
            throw new ExceptionsClasse("##Digite um numero inteiro de 1 à 9##\n");
        }
    }
        public void entradaIncorretaMenuAtualizacao(int escolhaMenuRemocao) throws ExceptionsClasse{
        if (escolhaMenuRemocao < 1 || escolhaMenuRemocao > 8) {
            throw new ExceptionsClasse("##Digite um numero inteiro de 1 à 4##\n");
        }
    }



}


