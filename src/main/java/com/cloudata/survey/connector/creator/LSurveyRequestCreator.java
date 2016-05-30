/**
 * File name: LSurveyRequestCreator
 * Author: Dorsey Q F TANG
 * Date: 5/28/16
 * -----------------------------------------------------
 * Description:
 * -----------------------------------------------------
 */

package com.cloudata.survey.connector.creator;

import com.cloudata.survey.connector.struct.LSurveyRequest;

/**
 *
 * Author: DORSEy
 */
public interface LSurveyRequestCreator {
    /**
     * Returns an instance of {@link LSurveyRequest}.
     *
     * @return an instance of {@link LSurveyRequest}.
     */
    LSurveyRequest create();
}
