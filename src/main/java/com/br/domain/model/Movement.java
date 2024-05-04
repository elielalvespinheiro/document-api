package com.br.domain.model;

import com.br.domain.model.enums.TypeMovement;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "TBL_MOV_DOCUMENT")
@Entity
public class Movement implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long movementId;

    @Column(name = "pessoaRecebedora")
    private Long pessoaRecebedora;

    @Column(name = "subscritor")
    private Long subscritor;

    @Column(name = "date_time")
    @CreationTimestamp
    private LocalDateTime dataHora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mobil_id")
    private Mobil mobil;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo_movimentacao")
    private TypeMovement typeMovement;
    
    @Column(name = "cancelada")
    private boolean cancelada;

}