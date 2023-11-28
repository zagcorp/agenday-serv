package com.agenday.agendayserv.empresa.expediente;

import com.agenday.agendayserv.empresa.Empresa;

import lombok.*;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

@Entity
@Table(name = "expediente_empresa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ExpedienteEmpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_expediente_empresa")
    @SequenceGenerator(name = "seq_expediente_empresa", sequenceName = "seq_expediente_empresa")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "dia_semana")
    @Enumerated(EnumType.STRING)
    private DayOfWeek diaSemana;

    @Column(name = "abertura_matutino")
    private LocalTime aberturaMatutino;

    @Column(name = "fechamento_matutino")
    private LocalTime fechamentoMatutino;

    @Column(name = "abertura_vespertino")
    private LocalTime aberturaVespertino;

    @Column(name = "fechamento_vespertino")
    private LocalTime fechamentoVespertino;

    @JoinColumn(name = "id_empresa", updatable = true, nullable = false)
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Empresa empresa;

    public Long obterTotalMinutos() {
        var matutino = Duration.between(getAberturaMatutino(), getFechamentoMatutino());
        var vespertino = Duration.between(getAberturaVespertino(), getFechamentoVespertino());

        return matutino.toMinutes() + vespertino.toMinutes();
    }
}
