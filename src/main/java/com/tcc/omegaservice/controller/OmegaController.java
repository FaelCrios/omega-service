package com.tcc.omegaservice.controller;

import com.tcc.omegaservice.service.OmegaService;
import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OmegaController {

    @Autowired
    OmegaService service;

    @GetMapping("/omega")
    @Observed(
            name = "user.name",
            contextualName = "omega-->service",
            lowCardinalityKeyValues = {"userType","userType2"}
    )
    public String cominicacaoModulos(){
        log.info("Serviço omega foi chamado");
        return service.createFunction();
    }
}
