package com.wcsp.pe.mstipocambio.infrastructure.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipo_cambio")
public class TipoCambioEntity {

  @Id
  @Column(columnDefinition = "INT")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(columnDefinition = "NUMERIC(18,6) NOT NULL")
  private Double monto;

//  @Column(columnDefinition = "NUMERIC(18,6) NOT NULL")
//  private Double montoTipoCambio;

  @Column(columnDefinition = "VARCHAR(10) NOT NULL")
  private String monedaOrigen;

  @Column(columnDefinition = "VARCHAR(10) NOT NULL")
  private String monedaDestino;

  @Column(columnDefinition = "NUMERIC(18,6) NOT NULL")
  private Double tipoCambio;

  @Column(columnDefinition = "TIMESTAMP NOT NULL")
  private LocalDateTime fechaCambio;

}
