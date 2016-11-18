package com.paxport.lookup.airline;


import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class Airlines {

    private final static String AIRLINES_RESOURCE = "airlines.dat";

    private static List<String[]> parse(){
        // The settings object provides many configuration options
        CsvParserSettings parserSettings = new CsvParserSettings();

        //You can configure the parser to automatically detect what line separator sequence is in the input
        parserSettings.setLineSeparatorDetectionEnabled(true);

        // A RowListProcessor stores each parsed row in a List.
        RowListProcessor rowProcessor = new RowListProcessor();

        // You can configure the parser to use a RowProcessor to process the values of each parsed row.
        // You will find more RowProcessors in the 'com.univocity.parsers.common.processor' package, but you can also create your own.
        parserSettings.setProcessor(rowProcessor);

        // Let's consider the first parsed row as the headers of each column in the file.
        parserSettings.setHeaderExtractionEnabled(true);

        // creates a parser instance with the given settings
        CsvParser parser = new CsvParser(parserSettings);

        // parses all rows in one go.
        return parser.parseAll(resourceAsStream());
    }

    private static InputStream resourceAsStream() {
        return Airlines.class.getClassLoader().getResourceAsStream(AIRLINES_RESOURCE);
    }

    public static List<Airline> all(){
        return parse().stream()
                .map(row -> new Airline(row))
                .collect(Collectors.toList());
    }

}
