package com.wcsp.pe.mstipocambio.domain.dto.response;

import java.util.Map;
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
public class TipoCambioFeignResponse {

  private String result;
  private Map<String, Double> rates;

}
