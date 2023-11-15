package com.agenday.agendayserv.cliente;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cliente", uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }, name = "cku_email_cliente")})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_cliente")
    @SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "telefone")
    private String telefone;
}
