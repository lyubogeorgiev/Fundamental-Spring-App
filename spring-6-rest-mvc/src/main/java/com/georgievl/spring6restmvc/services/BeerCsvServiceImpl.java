package com.georgievl.spring6restmvc.services;

import com.georgievl.spring6restmvc.model.BeerCSVRecord;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
public class BeerCsvServiceImpl implements BeerCsvService {
    @Override
    public List<BeerCSVRecord> convertCSV(File file) {
        try {
            List<BeerCSVRecord> records = new CsvToBeanBuilder<BeerCSVRecord>(new FileReader(file))
                    .withType(BeerCSVRecord.class)
                    .build()
                    .parse();

            return records;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
