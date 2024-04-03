package com.example.ElasticitySpring.book.repository;

import org.springframework.data.elasticsearch.annotations.Query;
import com.example.ElasticitySpring.book.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.util.List;

@EnableElasticsearchRepositories
public interface BookRepository extends ElasticsearchRepository<Book, String> {

    List<Book> findByAuthor(String author);

    List<Book> findByTitle(String title);

     @Query(value ="""
      "_source": {"includes": "title"}
      {
        "multi_match": {
            "query": "?0",
            "fields": ["title","synopsis"]
        }
      }
    """)
    List<Book> searchBySynopsisAndTitle(String search);


    @Query(value ="""
      "_source": {"includes": ["title","synopsis"]}
      {
        "multi_match": {
            "query": "?0",
            "fields": ["title^3","synopsis"]
        }
      }
    """)
    List<Book> searchBySynopsisAndTitle_boost(String search);

    @Query(value ="""
      {
        "match_phrase": {
            "synopsis": {
                "query": "?0"
                "slop": 2
            }
        },
        "highlight": {
          "fields": {
               "synopsis": {}
          }
        }
      }
    """)
    List<Book> searchByPhraseInSynopsis(String search);

    @Query(value ="""
      {
        "match_phrase_prefix": {
            "title": "?0"
        }
      }
    """)
    List<Book> searchByTitlePrefix(String title);

    @Query(value ="""
      {
        "fuzzy": {
            "title": {
                "value": "?0",
                "fuzziness": 1
            }
        }
      }
    """)
    List<Book> searchByTitleFuzzy(String title);

    @Query(value = """
     {
       "_source": ["title","edition"],
       "term":{
         "edition":{
             value: "?0"
         }
      }
     }
     """)
    List<Book> searchByEdition_term(int edition);

    @Query(value = """
            {
            range: {
                " "amazon_rating": {
                    "gte": "?0",
                    "lte": "?1"
                }
            }
          """)
    List<Book> searchByAmazonRating_range(double min, double max);
}

