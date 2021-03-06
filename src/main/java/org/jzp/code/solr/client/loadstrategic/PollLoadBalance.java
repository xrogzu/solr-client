package org.jzp.code.solr.client.loadstrategic;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.solr.client.solrj.SolrServer;

/**
 * 选取slave策略类实现:轮询策略
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-03-30
 */
public class PollLoadBalance extends AbstractLoadBalance<SolrServer> {
	
	private AtomicInteger index = new AtomicInteger();

	public SolrServer doSelect(List<SolrServer> resources) {
		return resources.get(Math.abs(index.getAndIncrement() % resources.size()));
	}
}
