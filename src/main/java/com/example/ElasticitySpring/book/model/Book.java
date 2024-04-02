package com.example.ElasticitySpring.book.model;

import lombok.*;
import org.joda.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "books")
public class Book {

    @Id
    private String id;

    private String title;

    private String author;

    private int edition;

    private String synopsis;

    private LocalDate releaseDate;

    private double averageRating;

    private boolean bestSeller;

    private double amazonRating;

    private Price price;

    @Builder
    @Setter
    @Getter
    @AllArgsConstructor
    public static class Price {
        private double usd;
        private double gbd;
        private double eur;
        private double NGN;
    }
}
