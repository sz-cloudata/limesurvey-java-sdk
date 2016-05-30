/**
 * File name: LSurveyRequest
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
import org.apache.http.entity.StringEntity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/**
 * The request entity sent to Lime Survey server so that the server can act as expected.
 *
 * Author: DORSEy
 */
public class LSurveyRequest implements Serializable {
    /**
     * The action name performed by Lime Survey.
     */
    private String method;

    /**
     * The requested parameters that required to perform the associated action.
     */
    private ReqParams reqParams;

    /**
     * The id.
     */
    private final int id = 1;

    /**
     * Empty constructor of {@link LSurveyRequest}.
     */
    public LSurveyRequest() {}

    /**
     * Constructor of {@link LSurveyRequest}, with method and requested parameters specified.
     * @param method the method.
     * @param reqParams the requested parameters.
     */
    public LSurveyRequest(final String method, final ReqParams reqParams) {
        this.method = method;
        this.reqParams = reqParams;
    }

    public ReqParams getReqParams() {
        return reqParams;
    }

    public void setReqParams(ReqParams reqParams) {
        this.reqParams = reqParams;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Returns an instance of {@link StringEntity}.
     *
     * @return a {@link StringEntity}
     * @throws UnsupportedEncodingException
     */
    public StringEntity toEntity() throws UnsupportedEncodingException {
        StringBuilder builder = new StringBuilder();
        builder.append("{").append("\"").append(LSurveyConstants.SERIALIZED_METHOD).append("\": \"").append(this.method);
        builder.append("\", \"").append(LSurveyConstants.SERIALIZED_PARAMS).append("\": {").append(reqParams.toString());
        builder.append("}, \"").append(LSurveyConstants.SERIALIZED_ID).append("\": ").append(id);
        builder.append("}");

        return new StringEntity(builder.toString());
    }
}
