package com.georgievl.spring6restmvc.services;

import com.georgievl.spring6restmvc.model.BeerCSVRecord;

import java.io.File;
import java.util.List;

public interface BeerCsvService {
    List<BeerCSVRecord> convertCSV(File file);
}
