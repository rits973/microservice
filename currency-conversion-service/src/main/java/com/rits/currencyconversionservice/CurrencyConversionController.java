package com.rits.currencyconversionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ritesh Singh
 * @version 1.0
 * @since 23/08/18
 */
@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrenyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,@PathVariable BigDecimal quantity){
        Map<String, String > uriValiables = new HashMap<>();
        uriValiables.put("from",from);
        uriValiables.put("to",to);
        ResponseEntity<CurrenyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrenyConversionBean.class,
                uriValiables);
        CurrenyConversionBean responseEntityBody = responseEntity.getBody();

        return new CurrenyConversionBean(responseEntityBody.getId(),from,to,responseEntityBody.getConversionMultiple(),quantity,quantity.multiply(responseEntityBody.getConversionMultiple()),responseEntityBody.getPort());
    }
    @GetMapping("/currency-feign-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrenyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,@PathVariable BigDecimal quantity){
        CurrenyConversionBean responseEntityBody = currencyExchangeProxy.retrieveExchangeValue(from,to);
        logger.info("{}",responseEntityBody);
        return new CurrenyConversionBean(responseEntityBody.getId(),from,to,responseEntityBody.getConversionMultiple(),quantity,quantity.multiply(responseEntityBody.getConversionMultiple()),responseEntityBody.getPort());
    }
}
