package redoing.imc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Locale;

@Entity
public class IMC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double peso;
    private double altura;
    private double imcCalculado;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataCalculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public double getImcCalculado() {
        return imcCalculado;
    }

    public void setImcCalculado() {
        NumberFormat decimal = DecimalFormat.getInstance(Locale.ENGLISH);
        decimal.setMaximumFractionDigits(2);
        String imcCalculado = decimal.format(this.peso / (Math.pow(this.altura, 2)));
        this.imcCalculado = Double.parseDouble(imcCalculado);
    }

    public LocalDateTime getDataCalculo() {
        return dataCalculo;
    }

    public void setDataCalculo() {
        this.dataCalculo = LocalDateTime.now();
    }

    public User getUsuario() {
        return user;
    }

    public void setUsuario(User user) {
        this.user = user;
    }
}
