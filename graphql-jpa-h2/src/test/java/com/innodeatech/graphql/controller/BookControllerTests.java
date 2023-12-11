package com.innodeatech.graphql.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(BookController.class)
public class BookControllerTests {

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void shouldGetFirstBook() {
        this.graphQlTester
                .document("""
                        {
                        bookById(id: 1) {
                            id
                            name        
                            pageCount
                            author {
                              firstName
                              lastName
                            }
                          }
                        }
                        """)
                .execute()
                .path("bookById")
                .matchesJson("""
                            {
                                "id": "1",
                                "name": "Effective Java",
                                "pageCount": 416,
                                "author": {
                                  "firstName": "Joshua",
                                  "lastName": "Bloch"
                                }
                            }
                        """);
    }

    @Test
    void shouldGetFirstBook2() {
        this.graphQlTester
                .documentName("book")
                .execute()
                .path("bookById")
                .matchesJson("""
                            {
                               "id": "2",
                               "name": "Hitchhiker's Guide to the Galaxy",
                               "pageCount": 208,
                               "author": {
                                 "firstName": "Douglas",
                                 "lastName": "Adams"
                               }
                             }
                        """);
    }
}
