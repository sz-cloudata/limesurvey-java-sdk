/**
 * File name: GroupResponseDetails Author: Dorsey Q F TANG Date: 6/4/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.view;

import com.cloudata.survey.connector.LSurveyConstants;
import com.google.gson.annotations.SerializedName;

/**
 *
 * Author: DORSEy
 */
public class GroupResponseDetails implements Resp {

    @SerializedName(LSurveyConstants.SERIALIZED_ID)
    private GroupIdentifier identifier;

    /**
     * The group ID.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_LIST_GROUP_ID)
    private int groupId;

    /**
     * The survey ID.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_LIST_SURVEY_ID)
    private int surveyId;

    /**
     * The group name.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_GROUP_NAME)
    private String groupName;

    /**
     * The group order.
     */
    @SerializedName(LSurveyConstants.SERIALIZED_GROUP_ORDER)
    private String groupOrder;

    @SerializedName(LSurveyConstants.SERIALIZED_LIST_GROUP_DESC)
    private String groupDescription;

    @SerializedName(LSurveyConstants.SERIALIZED_LANGUAGE)
    private String language;

    @SerializedName(LSurveyConstants.SERIALIZED_RANDOMIZED_GROUP)
    private String randomizedGroup;

    @SerializedName(LSurveyConstants.SERIALIZED_GROUP_RELEVANCE)
    private String groupRelevance;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupOrder() {
        return groupOrder;
    }

    public void setGroupOrder(String groupOrder) {
        this.groupOrder = groupOrder;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRandomizedGroup() {
        return randomizedGroup;
    }

    public void setRandomizedGroup(String randomizedGroup) {
        this.randomizedGroup = randomizedGroup;
    }

    public String getGroupRelevance() {
        return groupRelevance;
    }

    public void setGroupRelevance(String groupRelevance) {
        this.groupRelevance = groupRelevance;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(LSurveyConstants.SERIALIZED_LIST_GROUP_ID).append(": ").append(groupId);
        builder.append(", ").append(LSurveyConstants.SERIALIZED_LIST_SURVEY_ID).append(": ").append(surveyId);
        builder.append(", ").append(LSurveyConstants.SERIALIZED_GROUP_NAME).append(": ").append(groupName);
        builder.append(", ").append(LSurveyConstants.SERIALIZED_LIST_GROUP_DESC).append(": ").append(groupDescription);
        builder.append(", ").append(LSurveyConstants.SERIALIZED_LANGUAGE).append(": ").append(language);
        builder.append(", ").append(LSurveyConstants.SERIALIZED_RANDOMIZED_GROUP).append(": ").append(randomizedGroup);
        builder.append(", ").append(LSurveyConstants.SERIALIZED_GROUP_RELEVANCE).append(": ").append(groupRelevance);

        return builder.toString();
    }

    public static class GroupIdentifier {
        @SerializedName(LSurveyConstants.SERIALIZED_LIST_GROUP_ID)
        private int groupId;

        @SerializedName(LSurveyConstants.SERIALIZED_LANGUAGE)
        private String language;

        public int getGroupId() {
            return groupId;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }
    }
}
