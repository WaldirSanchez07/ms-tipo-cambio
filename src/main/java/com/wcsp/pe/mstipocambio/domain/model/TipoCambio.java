package com.wcsp.pe.mstipocambio.domain.model;

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
public class TipoCambio {

  private Double monto;
  private Double montoTipoCambio;
  private String monedaOrigen;
  private String monedaDestino;
  private Double tipoCambio;
  private LocalDateTime fechaCambio;

}
