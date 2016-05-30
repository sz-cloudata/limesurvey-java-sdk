/**
 * File name: InitConnRequest
 * Author: Dorsey Q F TANG
 * Date: 5/27/16
 * -----------------------------------------------------
 * Description:
 * -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

import com.cloudata.survey.connector.LSurveyConstants;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Implementation of {@link ReqParams}, it contains parameters that required for establish the connection
 * between client and the server side.
 *
 * Author: DORSEy
 */
public class InitConnRequest implements ReqParams {
    /**
     * The user name used to login as.
     */
    @SerializedName("username")
    private String username;

    /**
     * The password used to identify whether it's correct.
     */
    @SerializedName("password")
    private String password;

    /**
     * Empty constructor of {@link InitConnRequest}.
     */
    public InitConnRequest(){}

    /**
     * Constructor of {@link InitConnRequest}, with user name and password specified.
     * @param username the user name.
     * @param password the password.
     */
    public InitConnRequest(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns a Json like string representation.
     *
     * <strong>
     *     "username": "$username", "password": "$password"
     * </strong>
     *
     */
    public String toString() {
        return "\"" + LSurveyConstants.SERIALIZED_USER_NAME + "\": \"" + username + "\", \"" + LSurveyConstants.SERIALIZED_PASSWORD + "\": \"" + password + "\"";
    }
}
