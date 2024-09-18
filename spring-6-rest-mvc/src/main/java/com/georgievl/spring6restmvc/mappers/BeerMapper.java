package com.georgievl.spring6restmvc.mappers;
import com.georgievl.spring6restmvc.entities.Beer;
import com.georgievl.spring6restmvc.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    Beer beerDtoToBeer(BeerDTO dto);
    BeerDTO beerToBeerDTO(Beer beer);
}
