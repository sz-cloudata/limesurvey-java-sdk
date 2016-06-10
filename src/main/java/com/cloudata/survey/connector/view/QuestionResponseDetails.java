/**
 * File name: QuestionResponseDetails Author: Dorsey Q F TANG Date: 6/10/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.view;

import com.cloudata.survey.connector.LSurveyConstants;
import com.google.gson.annotations.SerializedName;

/**
 * The question response details.
 *
 * Author: DORSEy
 */
public class QuestionResponseDetails implements Resp {
    @SerializedName(LSurveyConstants.SERIALIZED_ID)
    private QuestionIdentifier identifier;

    @SerializedName(LSurveyConstants.SERIALIZED_RESP_QUESTION_ID)
    private int questionId;

    @SerializedName(LSurveyConstants.SERIALIZED_QUESTION_PARENT_ID)
    private int parentId;

    @SerializedName(LSurveyConstants.SERIALIZED_LIST_SURVEY_ID)
    private int surveyId;

    @SerializedName(LSurveyConstants.SERIALIZED_LIST_GROUP_ID)
    private int groupId;

    @SerializedName(LSurveyConstants.SERIALIZED_QUESTION_TYPE)
    private String type;

    @SerializedName(LSurveyConstants.SERIALIZED_QUESTION_TITLE)
    private String title;

    @SerializedName(LSurveyConstants.SERIALIZED_QUESTION_QUESTION)
    private String question;

    @SerializedName(LSurveyConstants.SERIALIZED_QUESTION_PREG)
    private String preg;

    @SerializedName(LSurveyConstants.SERIALIZED_HELP)
    private String help;

    @SerializedName(LSurveyConstants.SERIALIZED_OTHER)
    private String other;

    @SerializedName(LSurveyConstants.SERIALIZED_MANDATORY)
    private String mandatory;

    @SerializedName(LSurveyConstants.SERIALIZED_QUESTION_ORDER)
    private int questionOrder;

    @SerializedName(LSurveyConstants.SERIALIZED_LANGUAGE)
    private String language;

    @SerializedName(LSurveyConstants.SERIALIZED_SCALE_ID)
    private int scaleId;

    @SerializedName(LSurveyConstants.SERIALIZED_SAME_DEFAULT)
    private int sameDefault;

    @SerializedName(LSurveyConstants.SERIALIZED_RELEVANCE)
    private int relevance;

    @SerializedName(LSurveyConstants.SERIALIZED_MODULE_NAME)
    private String moduleName;

    public QuestionIdentifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(QuestionIdentifier identifier) {
        this.identifier = identifier;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getPreg() {
        return preg;
    }

    public void setPreg(String preg) {
        this.preg = preg;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

    public int getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(int questionOrder) {
        this.questionOrder = questionOrder;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getScaleId() {
        return scaleId;
    }

    public void setScaleId(int scaleId) {
        this.scaleId = scaleId;
    }

    public int getSameDefault() {
        return sameDefault;
    }

    public void setSameDefault(int sameDefault) {
        this.sameDefault = sameDefault;
    }

    public int getRelevance() {
        return relevance;
    }

    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public static class QuestionIdentifier implements Resp {
        @SerializedName(LSurveyConstants.SERIALIZED_RESP_QUESTION_ID)
        private int questionId;

        @SerializedName(LSurveyConstants.SERIALIZED_LANGUAGE)
        private String language;

        public int getQuestionId() {
            return questionId;
        }

        public void setQuestionId(final int questionId) {
            this.questionId = questionId;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(final String language) {
            this.language = language;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("questionId: ").append(questionId).append(", ");
        builder.append("parentId: ").append(parentId).append(", ");
        builder.append("surveyId: ").append(surveyId).append(", ");
        builder.append("groupId: ").append(groupId).append(", ");
        builder.append("type: ").append(type).append(", ");
        builder.append("title: ").append(title).append(", ");
        builder.append("question: ").append(question).append(", ");
        builder.append("mandatory: ").append(mandatory);
        builder.append("}");

        return builder.toString();
    }
}
