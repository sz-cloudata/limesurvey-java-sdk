/**
 * File name: ProcessResultCallback Author: Dorsey Q F TANG Date: 6/4/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.callback;

/**
 *
 * Author: DORSEy
 */
public interface ProcessResultCallback<T> {
    /**
     *
     *
     * @param result
     * @param <T>
     * @return
     */
    T doWithResult(final Object result);
}
