package redoing.imc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import redoing.imc.model.IMC;

public class ImcDto {

    @NotNull
    private double peso;
    @NotNull
    private double altura;

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public IMC toIMC(){
        IMC imc = new IMC();
        imc.setPeso(peso);
        imc.setAltura(altura);
        imc.setImcCalculado();
        imc.setDataCalculo();
        return imc;
    }
}
