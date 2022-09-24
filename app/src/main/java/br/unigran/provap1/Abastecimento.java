package br.unigran.provap1;

public class Abastecimento {

    private Integer id;
    private String km;
    private String qtdabastecida;
    private String diaabastecido;
    private String valor;

    public String getKm() {
        return km;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getQtdabastecida() {
        return qtdabastecida;
    }

    public void setQtdabastecida(String qtdabastecida) {
        this.qtdabastecida = qtdabastecida;
    }

    public String getDiaabastecido() {
        return diaabastecido;
    }

    public void setDiaabastecido(String diaabastecido) {
        this.diaabastecido = diaabastecido;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
