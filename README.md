# solr-client
solr客户端
添加 solr-client 依赖：
<dependency>
    <groupId>com.le.jr</groupId>
    <artifactId>solr-client</artifactId>
    <version>0.0.3-SNAPSHOT</version>
</dependency>

spring配置文件配置：
<!-- master，slave数据源组配置 -->
<bean id="solrServerGroup" class="com.le.jr.solr.client.datasource.SolrServerGroup" destroy-method="destory">
   <property name="masterServer">
      <bean class="org.apache.solr.client.solrj.impl.HttpSolrServer">
         <constructor-arg>
            <value>http://10.11.147.40:6080/solr/collection2</value>
         </constructor-arg>
         <property name="connectionTimeout" value="1000" />
         <property name="soTimeout" value="1500" />
      </bean>
   </property>

   <property name="slaveServerList">
      <list>
         <bean class="org.apache.solr.client.solrj.impl.HttpSolrServer">
            <constructor-arg>
               <value>http://10.11.147.40:6080/solr/collection2</value>
            </constructor-arg>
            <property name="connectionTimeout" value="1000" />
            <property name="soTimeout" value="1500" />
         </bean>
 
		 <bean class="org.apache.solr.client.solrj.impl.HttpSolrServer">
            <constructor-arg>
               <value>http://10.11.147.40:6080/solr/collection2</value>
            </constructor-arg>
            <property name="connectionTimeout" value="1000" />
            <property name="soTimeout" value="1500" />
         </bean>
      </list>
   </property>

   <property name="loadBalance">
      <bean class="com.le.jr.solr.client.loadstrategic.RandomLoadBalance" />
   </property>
</bean>

<bean id="solrClient" class="com.le.jr.solr.client.SolrHttpClient">
   <property name="solrServerGroup" ref="solrServerGroup" />
</bean>

<!-- master，slave数据源组配置 -->
<bean id="solrServerGroup" class="com.le.jr.solr.client.datasource.SolrServerGroup" destroy-method="destory">
   <property name="masterServer">
      <bean class="org.apache.solr.client.solrj.impl.HttpSolrServer">
         <constructor-arg>
            <value>http://10.11.147.40:6080/solr/collection2</value>
         </constructor-arg>
         <property name="connectionTimeout" value="1000" />
         <property name="soTimeout" value="1500" />
      </bean>
   </property>

   <property name="slaveServerList">
      <list>
         <bean class="org.apache.solr.client.solrj.impl.HttpSolrServer">
            <constructor-arg>
               <value>http://10.11.147.40:6080/solr/collection2</value>
            </constructor-arg>
            <property name="connectionTimeout" value="1000" />
            <property name="soTimeout" value="1500" />
         </bean>
 
		 <bean class="org.apache.solr.client.solrj.impl.HttpSolrServer">
            <constructor-arg>
               <value>http://10.11.147.40:6080/solr/collection2</value>
            </constructor-arg>
            <property name="connectionTimeout" value="1000" />
            <property name="soTimeout" value="1500" />
         </bean>
      </list>
   </property>

   <property name="loadBalance">
      <bean class="com.le.jr.solr.client.loadstrategic.PollLoadBalance" />
   </property>
</bean>

<bean id="solrClient" class="com.le.jr.solr.client.SolrHttpClient">
   <property name="solrServerGroup" ref="solrServerGroup" />
</bean>

<!-- master，slave数据源组配置 -->
<bean id="solrServerGroup" class="com.le.jr.solr.client.datasource.SolrServerGroup" destroy-method="destory">
   <property name="masterServer">
      <bean class="org.apache.solr.client.solrj.impl.HttpSolrServer">
         <constructor-arg>
            <value>http://10.11.147.40:6080/solr/collection2</value>
         </constructor-arg>
         <property name="connectionTimeout" value="1000" />
         <property name="soTimeout" value="1500" />
      </bean>
   </property>

   <property name="slaveServerList">
      <list>
		<bean class="com.le.jr.solr.client.datasource.WeightSolrServer">
   			<constructor-arg index="0">
      			<value>3</value>
   			</constructor-arg>
   			<constructor-arg index="1">
      			<bean class="org.apache.solr.client.solrj.impl.HttpSolrServer">
         			<constructor-arg>
            			<value>http://10.11.147.40:6080/solr/collection2</value>
         			</constructor-arg>
         			<property name="connectionTimeout" value="1000" />
         			<property name="soTimeout" value="1500" />
      			</bean>
   			</constructor-arg>
		</bean>
		<bean class="com.le.jr.solr.client.datasource.WeightSolrServer">
   			<constructor-arg index="0">
      			<value>7</value>
   			</constructor-arg>
   			<constructor-arg index="1">
      			<bean class="org.apache.solr.client.solrj.impl.HttpSolrServer">
         			<constructor-arg>
            			<value>http://10.11.147.40:6080/solr/collection2</value>
         			</constructor-arg>
         			<property name="connectionTimeout" value="1000" />
         			<property name="soTimeout" value="1500" />
      			</bean>
   			</constructor-arg>
		</bean>
      </list>
   </property>

   <property name="loadBalance">
      <bean class="com.le.jr.solr.client.loadstrategic.WeightLoadBalance" />
   </property>
</bean>

<bean id="solrClient" class="com.le.jr.solr.client.SolrHttpClient">
   <property name="solrServerGroup" ref="solrServerGroup" />
</bean>

自动提交设置
默认情况下，客户端如果不配置，则视为手动提交索引，此为高并发的情况下，如订单模块，则可以设置此属性，让solr自动提交索引数据，客户端视情况选择。
注意：如果设置autoCommit为true，则在solr里面的数据会有延迟
线上环境的订单autoCommit为15s提交一次
 
<bean id="solrClient" class="com.le.jr.solr.client.SolrHttpClient">
	<property name="solrServerGroup" ref="solrServerGroup" />
	<property name="autoCommit" value="true" />
</bean>
