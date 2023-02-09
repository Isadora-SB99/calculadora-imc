package redoing.imc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "authorities")
public class Authorities {

    @Id
    private String username;

    private String authority;
}
