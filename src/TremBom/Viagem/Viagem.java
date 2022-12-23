
package TremBom.Viagem;

import TremBom.Ferroviaria.Ferroviaria;
import TremBom.Locomotiva.tipoLocomotiva;


public class Viagem {
    
    tipoLocomotiva locomotiva;
    String dataSaida;
    String horaSaida;
    String dataChegada;
    String horaChegada;
    Ferroviaria ferroviaraDestino;
    Ferroviaria ferroviaraSaida;

    public Viagem(tipoLocomotiva locomotiva, String dataSaida, String horaSaida, String dataChegada, String horaChegada, Ferroviaria ferroviaraDestino, Ferroviaria ferroviaraSaida) {
        this.locomotiva = locomotiva;
        this.dataSaida = dataSaida;
        this.horaSaida = horaSaida;
        this.dataChegada = dataChegada;
        this.horaChegada = horaChegada;
        this.ferroviaraDestino = ferroviaraDestino;
        this.ferroviaraSaida = ferroviaraSaida;
    }

    public tipoLocomotiva getLocomotiva() {
        return locomotiva;
    }

    public void setLocomotiva(tipoLocomotiva locomotiva) {
        this.locomotiva = locomotiva;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(String dataChegada) {
        this.dataChegada = dataChegada;
    }

    public String getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(String horaChegada) {
        this.horaChegada = horaChegada;
    }

    public Ferroviaria getFerroviaraDestino() {
        return ferroviaraDestino;
    }

    public void setFerroviaraDestino(Ferroviaria ferroviaraDestino) {
        this.ferroviaraDestino = ferroviaraDestino;
    }

    public Ferroviaria getFerroviaraSaida() {
        return ferroviaraSaida;
    }

    public void setFerroviaraSaida(Ferroviaria ferroviaraSaida) {
        this.ferroviaraSaida = ferroviaraSaida;
    }
    
    
}
