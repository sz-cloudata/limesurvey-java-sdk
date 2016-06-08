/**
 * File name: LSurveyQuestion Author: Dorsey Q F TANG Date: 6/8/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.importer;

import java.io.Serializable;
import java.util.List;

/**
 * Demonstrates the question skeleton.
 *
 * Author: DORSEy
 */
public class LSurveyQuestion implements Serializable {
    /**
     * The question ID.
     */
    private int questionId;

    /**
     * The parent question ID. default 0, to indicates that no parent associated with.
     */
    private int parentQuestionId = 0;

    /**
     * The survey ID.
     */
    private int surveyId;

    /**
     * The group id.
     */
    private int groupId;

    /**
     * The question type.
     */
    private String type;

    /**
     * The title of the question.
     */
    private String questionTitle;

    /**
     * The question.
     */
    private String question;

    /**
     * Indicates whether it's mandatory or not. "Y" for yes, "N" for no.
     */
    private String mandatory;

    /**
     * The answers to this question.
     */
    private List<LSurveyAnswer> answers;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getParentQuestionId() {
        return parentQuestionId;
    }

    public void setParentQuestionId(int parentQuestionId) {
        this.parentQuestionId = parentQuestionId;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{").append("questionId: ").append(questionId);
        builder.append(", parentQuestionId: ").append(parentQuestionId);
        builder.append(", surveyId: ").append(surveyId);
        builder.append(", groupId: ").append(groupId);
        builder.append(", type: ").append(type);
        builder.append(", title: ").append(questionTitle);
        builder.append(", question: ").append(question);
        builder.append(", mandatory: ").append(mandatory);
        builder.append("}");

        return builder.toString();
    }
}
