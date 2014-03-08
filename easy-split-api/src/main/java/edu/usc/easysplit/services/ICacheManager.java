package edu.usc.easysplit.services;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface ICacheManager {
	
	/** Value Operations */
	void storeValue(Object key, Object value);
	
	void storeUncmprsdValue (Object key, Object value);

	void storeValueWithTTL(Object key, Object value, long timeout, TimeUnit unit);
	
	void storeUncmprsdValueWithTTL(Object key, Object value, long timeout, TimeUnit unit);

	Object getValue(Object key);
	
	Object getUncmprsdValue(Object key);

	Object replaceValue(Object key, Object value);

	List<Object> getMultipleValues(List<Object> keys);

	void setMultipleValues(Map<Object, Object> map);
	
	void delKey(Object key);
	
	boolean hasMapKey(Object key);
	
	
	/** List Based Operations */
	void leftPush(Object key, Object value);

	void rightPush(Object key, Object value);

	Object leftPop(Object key, long timeout, TimeUnit unit);

	Object rightPop(Object key, long timeout, TimeUnit unit);
	
	
	/** Hash operations */
	Set<Object> getAllSubKeys (Object key);
	
	List<?> getAllSubValues (Object key);

	Object getValue (Object key, Object hashKey);
	
	Object getStoredMap (Object key);
	
	Collection<Object> getMultiValues (Object key, Collection<Object> hashKeys);
	
	Boolean hasValueForKeys (Object key, Object hashKey);
	
	Long getNoOfKeysStored (Object key);
	
	void deleteMap (Object key);
	
	void deleteValue (Object key, Object hashKey);

	void storeMap (Object key, Map<? extends Object, ? extends Object> m);

	void storeValue (Object key, Object hashKey, Object value);
	
	Boolean storeValueIfAbsent (Object key, Object hashKey, Object value);
	
	void storeMapWithTTL (Object key, Map<? extends Object, ? extends Object> m, long timeout, TimeUnit unit);
	
	void storeValueWithTTL (Object key, Object hashKey, Object value, long timeout, TimeUnit unit);
	
	Boolean storeValueIfAbsentWithTTL (Object key, Object hashKey, Object value, long timeout, TimeUnit unit);
	
	void setKeyTTL (Object key, long timeout, TimeUnit unit);
}