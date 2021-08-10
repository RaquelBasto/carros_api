package com.carros.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data//unico argumento para getter, setter, constructor etc
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    @Column(name = "url_foto")
    private String urlFoto;
    @Column(name = "url_video")
    private String urlVideo;
    private String latitude;
    private String longitude;
    private String tipo;

}
