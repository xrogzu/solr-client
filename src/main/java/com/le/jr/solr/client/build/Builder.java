package com.le.jr.solr.client.build;

import org.apache.solr.client.solrj.SolrQuery;

import java.lang.reflect.Field;

/**
 * 建造者父类
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-06-27
 */
public abstract class Builder {

    /**
     * builder entry
     *
     * @param field
     * @param object
     * @throws IllegalAccessException
     */
    public abstract void buildQuery(Field field, Object object) throws IllegalAccessException;

    /**
     * builder page
     *
     * @param field
     * @param object
     * @throws IllegalAccessException
     */
    public abstract void buildPage(Field field, Object object) throws IllegalAccessException;

    /**
     * builder scope
     *
     * @param field
     * @param object
     * @throws IllegalAccessException
     */
    public abstract void buildScope(Field field, Object object) throws IllegalAccessException;

    /**
     * builder common
     *
     * @param field
     * @param object
     * @throws IllegalAccessException
     */
    public abstract void buildCommon(Field field, Object object) throws IllegalAccessException;

    /**
     * get SolrQuery
     *
     * @return SolrQuery
     */
    public abstract SolrQuery getResult();

}