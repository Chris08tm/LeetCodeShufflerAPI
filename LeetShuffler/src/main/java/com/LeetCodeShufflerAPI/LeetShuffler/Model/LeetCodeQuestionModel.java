package com.LeetCodeShufflerAPI.LeetShuffler.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question")
public class LeetCodeQuestionModel {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String difficulty;
    private String tag;

    public String getName() {
        return name;
    }
}
