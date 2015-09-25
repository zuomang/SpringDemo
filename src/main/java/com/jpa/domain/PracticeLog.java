package com.jpa.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Mang on 15/9/24.
 */
@Entity
@Table(name = "T_EXERCISE_PRACTICE_LOG")
public class PracticeLog implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "idGenerator", strategy = "identity")
    @GeneratedValue(generator = "idGenerator")
    private int id;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "LIBRARY_ID")
    private int libraryId;

    @Column(name = "PRACTICE_TYPE")
    private String practiceType;

    @Column(name = "QUESTION_OFFSET")
    private int questionOffset;

    @Column(name = "CREATE_TIME")
    private Timestamp createTime;

    @Column(name = "UPDATE_TIME")
    private Timestamp updateTime;

    public PracticeLog() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public String getPracticeType() {
        return practiceType;
    }

    public void setPracticeType(String practiceType) {
        this.practiceType = practiceType;
    }

    public int getQuestionOffset() {
        return questionOffset;
    }

    public void setQuestionOffset(int questionOffset) {
        this.questionOffset = questionOffset;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
