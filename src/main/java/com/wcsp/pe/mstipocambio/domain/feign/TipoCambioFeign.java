package com.wcsp.pe.mstipocambio.domain.feign;

import com.wcsp.pe.mstipocambio.domain.dto.response.TipoCambioFeignResponse;

public interface TipoCambioFeign {

  TipoCambioFeignResponse findTipoCambio(String monedaOrigen);

}
