package br.com.api.system.api;

import br.com.api.system.DTO.CepDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepConsumer {

    private static final String PREFIX_URL = "/json";

    @Autowired
    private RestTemplate restTemplate;

    @Value("${viaCep.api.url}")
    private String url;

    public CepDTO consultarCep(String cep) {
        ResponseEntity<CepDTO> response = restTemplate.exchange(url + cep +PREFIX_URL, HttpMethod.GET, obterHttpEntity(), CepDTO.class);

        return (CepDTO) response.getBody();
    }

    private HttpEntity<String> obterHttpEntity() {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json;charset=UTF-8");

        return new HttpEntity<>(headers);
    }
}
