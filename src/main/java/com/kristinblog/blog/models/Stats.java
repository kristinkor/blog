package com.kristinblog.blog.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stats")
public class Stats {

    @Id
    @Column(name = "id")
    private Integer id = 1;

    @Column(name = "date")
    private String date;
    
    @Column(name = "views")
    private Long views;

}