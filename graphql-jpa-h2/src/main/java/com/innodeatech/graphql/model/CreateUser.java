package com.innodeatech.graphql.model;

import lombok.Getter;

import java.io.Serializable;


public record CreateUser( String id, String firstName, String lastName, String email) {

}
