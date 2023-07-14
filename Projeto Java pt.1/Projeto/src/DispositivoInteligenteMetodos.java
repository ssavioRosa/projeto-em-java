
public interface DispositivoInteligenteMetodos {

    public void addDispositivo();

    public void calcularConsumoDiario();

    public void calcularConsumoMensal();

    public void removerPeloNome(String nomeRemover);

    public void imprimeObjetos();
    
    public void desligarPorLimiteGasto(double limiteGastoWatts);

    public void removePorLimiteGastoDiario(double limiteGastoWatts);

    public void removePorLimiteGastoMensal(double limiteGastoWatts);

    public void calculaDiarioIndividual(String nomeEletrodomesticoIndividual);

    public void desligarTudo();

    public void ligarTudo();
    
    public void atualizaNome(String nomeNovo, String nomeBusca);
    
    public void atualizaLigadoDesligado(String ligadoDesligadoNovo, String nomeBusca);

    public void atualizaConsumo(double consumoNovo, String nomeBusca);

    public void atualizaHora(int horaNovo, int minutoNovo, String nomeBusca);
    
    public boolean analizaObjeto(String nomeEletrodomestico);

    public double gastoDiario(int hora, int minuto, double watts);

    public void menuRemove();

    public void menuIteracao();

    public void menuAtualizacao();

    

    

    
}
