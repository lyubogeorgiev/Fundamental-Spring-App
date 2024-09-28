package com.georgievl.spring6resttemplate.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.georgievl.spring6resttemplate.model.BeerDTO;
import com.georgievl.spring6resttemplate.model.BeerStyle;
import com.georgievl.spring6resttemplate.page.BeerDTOPageImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private static final String GET_BEER_PATH = "/api/v1/beer";
    private final RestTemplateBuilder restTemplateBuilder;

    @Override
    public Page<BeerDTO> listBeers(String beerName,
                                   BeerStyle beerStyle,
                                   Boolean showInventory,
                                   Integer pageNumber,
                                   Integer pageSize) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(GET_BEER_PATH);

        if (beerName != null && !beerName.isEmpty()) {
            uriComponentsBuilder.queryParam("name", beerName);
        }

        if (beerStyle != null) {
            uriComponentsBuilder.queryParam("style", beerStyle.toString());
        }

        if (showInventory != null) {
            uriComponentsBuilder.queryParam("showInventory", showInventory);
        }

        if (pageNumber != null) {
            uriComponentsBuilder.queryParam("pageNumber", pageNumber);
        }

        if (pageSize != null) {
            uriComponentsBuilder.queryParam("pageSize", pageSize);
        }

        ResponseEntity<String> stringResponse =
                restTemplate.getForEntity(uriComponentsBuilder.toUriString(), String.class);

        ResponseEntity<Map> mapResponse =
                restTemplate.getForEntity(uriComponentsBuilder.toUriString(), Map.class);

        ResponseEntity<JsonNode> jsonResponse =
                restTemplate.getForEntity(uriComponentsBuilder.toUriString(), JsonNode.class);

        jsonResponse.getBody().findPath("content")
                        .forEach(node -> {System.out.println(node.get("beerName").asText());});

        System.out.println(stringResponse.getBody());

        ResponseEntity<BeerDTOPageImpl> pageResponse =
                restTemplate.getForEntity(uriComponentsBuilder.toUriString(), BeerDTOPageImpl.class);

         return pageResponse.getBody();
    }

    @Override
    public Page<BeerDTO> listBeers() {

        return listBeers(null, null, null, null, null);
    }
}
