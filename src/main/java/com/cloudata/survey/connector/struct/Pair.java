/**
 * File name: Pair Author: Dorsey Q F TANG Date: 6/4/16 -----------------------------------------------------
 * Description: -----------------------------------------------------
 */

package com.cloudata.survey.connector.struct;

/**
 * The pair.
 *
 * Author: DORSEy
 */
public class Pair<K, V> {
    /**
     * The key name.
     */
    private final K key;

    /**
     * The value associated with.
     */
    private final V value;

    /**
     * Empty constructor of {@link Pair}.
     */
    public Pair() {
        this.key = null;
        this.value = null;
    }

    /**
     * Constructor of {@link Pair}, with key and value specified.
     *
     * @param key the key.
     * @param value the value.
     */
    public Pair(final K key, final V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key + ": " + value;
    }
}
