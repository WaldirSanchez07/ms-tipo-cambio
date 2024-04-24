package com.wcsp.pe.mstipocambio.infrastructure.feign;

import com.wcsp.pe.mstipocambio.domain.feign.TipoCambioFeign;
import com.wcsp.pe.mstipocambio.domain.dto.response.TipoCambioFeignResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-tipo-cambio", url = "${api-tipo-cambio.url}")
public interface TipoCambioFeignClient extends TipoCambioFeign {

  @Override
  @GetMapping(value = "/{monedaOrigen}")
  TipoCambioFeignResponse findTipoCambio(@PathVariable("monedaOrigen") String monedaOrigen);

}
