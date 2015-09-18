package com.jpa.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mang on 15/9/18.
 */
@Entity
@Table(name = "T_ALL_QUESTION_LIBRARY")
public class QuestionLibrary implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name="idGenerator", strategy = "identity")
    @GeneratedValue(generator = "idGenerator")
    public byte ID;

    @Column(name = "TITLE")
    public String title;

    @Column(name = "CONTENT")
    public String content;

    @Column(name = "COUNT_CHOICE")
    public short countChoice;

    @Column(name = "COUNT_OPINION")
    public short countOpinion;

    public QuestionLibrary() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public byte getID() {
        return ID;
    }

    public void setID(byte ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public short getCountChoice() {
        return countChoice;
    }

    public void setCountChoice(short countChoice) {
        this.countChoice = countChoice;
    }

    public short getCountOpinion() {
        return countOpinion;
    }

    public void setCountOpinion(short countOpinion) {
        this.countOpinion = countOpinion;
    }
}
