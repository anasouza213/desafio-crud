package com.g3tecnologia.crud.core.domain.business.users;

import com.g3tecnologia.crud.core.domain.business.email.EmailModel;
import com.g3tecnologia.crud.core.domain.business.phone.PhoneModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "users")
public class UserModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "password")
    private String password;

    @Column(name = "cep")
    private String cep;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "uf")
    private String uf;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "perfil")
    private Integer perfil;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_phone")
    private List<PhoneModel> phone;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_email")
    private List<EmailModel> email;
}
