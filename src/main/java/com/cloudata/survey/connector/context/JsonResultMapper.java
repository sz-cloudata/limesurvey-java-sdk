/**
 * File name: JsonResultMapper
 * Author: Dorsey Q F TANG
 * Date: 5/28/16
 * -----------------------------------------------------
 * Description:
 * -----------------------------------------------------
 */

package com.cloudata.survey.connector.context;

import com.cloudata.survey.connector.view.Resp;
import com.google.gson.Gson;

/**
 * Used to map the Json to an object.
 *
 * Author: DORSEy
 */
public class JsonResultMapper {
    public static final <T extends Resp> T map(final String json, final Class<T> kind) {
        if (json == null || json.isEmpty()) {
            throw new IllegalArgumentException("Argument[json] should not be null or empty");
        }

        Gson gson = new Gson();
        T result = gson.fromJson(json, kind);

        return result;
    }
}
