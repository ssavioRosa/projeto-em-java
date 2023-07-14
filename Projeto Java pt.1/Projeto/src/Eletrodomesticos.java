public class Eletrodomesticos {

    protected String nomeEletrodomestico;
    protected String estadoEletrodomestico;
    protected double consumoEletrodomestico;
    protected int horaEletrodomestico;
    protected int minutoEletrodomestico;

    public Eletrodomesticos(String nomeEletrodomestico, String estadoEletrodomestico,
            double consumoEletrodomestico, int horaEletrodomestico,
            int minutoEletrodomestico) {

        this.nomeEletrodomestico = nomeEletrodomestico;
        this.estadoEletrodomestico = estadoEletrodomestico;
        this.consumoEletrodomestico = consumoEletrodomestico;
        this.horaEletrodomestico = horaEletrodomestico;
        this.minutoEletrodomestico = minutoEletrodomestico;
    }



    public String getNomeEletrodomestico() {
        return nomeEletrodomestico;
    }

    public void setNomeEletrodomestico(String nomeEletrodomestico) {
        this.nomeEletrodomestico = nomeEletrodomestico;
    }

    public String getEstadoEletrodomestico() {
        return estadoEletrodomestico;
    }

    public void setEstadoEletrodomestico(String estadoEletrodomestico) {
        this.estadoEletrodomestico = estadoEletrodomestico;
    }

    public double getConsumoEletrodomestico() {
        return consumoEletrodomestico;
    }

    public void setConsumoEletrodomestico(double consumoEletrodomestico) {
        this.consumoEletrodomestico = consumoEletrodomestico;
    }

    public int getHoraEletrodomestico() {
        return horaEletrodomestico;
    }

    public void setHoraEletrodomestico(int horaEletrodomestico) {
        this.horaEletrodomestico = horaEletrodomestico;
    }

    public int getMinutoEletrodomestico() {
        return minutoEletrodomestico;
    }

    public void setMinutoEletrodomestico(int minutoEletrodomestico) {
        this.minutoEletrodomestico = minutoEletrodomestico;
    }



    @Override
    public String toString() {
        return "Eletrodomestico -> " + nomeEletrodomestico + "\nEstado -> "
                + estadoEletrodomestico + "\nConsumo -> " + consumoEletrodomestico
                + "\nTempo de uso -> " + horaEletrodomestico + " : " + minutoEletrodomestico + " Hrs\n";
    }

    

    
}
