package com.example.redisOptimization.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "stream_note")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Note implements Serializable { // the value which we are caching should be serializable
    @Id
    private String id;
    private String title;
    private String content;
    private Date addedDate;
    private boolean live = false;
}
