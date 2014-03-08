package edu.usc.easysplit.services.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import edu.usc.easysplit.services.ICacheManager;

public class CacheManagerImpl implements ICacheManager {

	private ValueOperations<Object, Object> valueOpsTemplate;
	
	private HashOperations<Object, Object, Object> hashOpsTemplate;

	public void set_cacheTemplate (RedisTemplate<Object, Object> _cacheTemplate) {
		this.valueOpsTemplate = _cacheTemplate.opsForValue();
		this.hashOpsTemplate = _cacheTemplate.opsForHash();
	}

	@Override
	public void storeValue (Object key, Object value) {
		this.valueOpsTemplate.set(key, value);
	}
	
	@Override
	public void storeValueWithTTL (Object key, Object value, long timeout, TimeUnit unit) {
		this.valueOpsTemplate.set(key, value, timeout, unit);
	}
	
	@Override
	public Object getValue (Object key) {
		return this.valueOpsTemplate.get(key);
	}

	@Override
	public Object replaceValue (Object key, Object value) {
		return this.valueOpsTemplate.getAndSet(key, value);
	}

	@Override
	public void delKey (Object key) {
		this.valueOpsTemplate.getOperations().delete(key);
	}
	
	@Override
	public boolean hasMapKey (Object key) {
		if (this.hashOpsTemplate.getOperations().hasKey(key) != null) {
			return true;
		}
		return false;
	}

	@Override
	public Set<Object> getAllSubKeys (Object key) {
		return this.hashOpsTemplate.keys(key);
	}

	@Override
	public List<?> getAllSubValues (Object key) {
		return (List<?>) this.hashOpsTemplate.values(key);
	}

	@Override
	public Object getValue (Object key, Object hashKey) {
		return this.hashOpsTemplate.get(key, hashKey);
	}
	
	@Override
	public Object getStoredMap (Object key) {
		return this.hashOpsTemplate.entries(key);
	}

	@Override
	public Collection<Object> getMultiValues (Object key, Collection<Object> hashKeys) {
		return this.hashOpsTemplate.multiGet(key, hashKeys);
	}

	@Override
	public Boolean hasValueForKeys (Object key, Object hashKey) {
		return this.hashOpsTemplate.hasKey(key, hashKey);
	}

	@Override
	public Long getNoOfKeysStored (Object key) {
		return this.hashOpsTemplate.size(key);
	}

	@Override
	public void deleteMap (Object key) {
		this.hashOpsTemplate.getOperations().delete(key);
	}
	
	@Override
	public void deleteValue (Object key, Object hashKey) {
		this.hashOpsTemplate.delete(key, hashKey);
	}

	@Override
	public void storeMap (Object key, Map<? extends Object, ? extends Object> m) {
		this.hashOpsTemplate.putAll(key, m);
	}

	@Override
	public void storeValue (Object key, Object hashKey, Object value) {
		this.hashOpsTemplate.put(key, hashKey, value);
	}

	@Override
	public Boolean storeValueIfAbsent (Object key, Object hashKey, Object value) {
		return this.hashOpsTemplate.putIfAbsent(key, hashKey, value);
	}
	
	@Override
	public void storeMapWithTTL (Object key, Map<? extends Object, ? extends Object> m, long timeout, TimeUnit unit) {
		this.hashOpsTemplate.putAll(key, m);
		this.hashOpsTemplate.getOperations().expire(key, timeout, unit);
	}

	@Override
	public void storeValueWithTTL (Object key, Object hashKey, Object value, long timeout, TimeUnit unit) {
		this.hashOpsTemplate.put(key, hashKey, value);
		this.hashOpsTemplate.getOperations().expire(hashKey, timeout, unit);
	}

	@Override
	public Boolean storeValueIfAbsentWithTTL (Object key, Object hashKey, Object value, long timeout, TimeUnit unit) {
		boolean returnFlag = this.hashOpsTemplate.putIfAbsent(key, hashKey, value);
		if (returnFlag) {
			this.hashOpsTemplate.getOperations().expire(hashKey, timeout, unit);
		}
		return returnFlag;
	}
	
	@Override
	public void setKeyTTL (Object key, long timeout, TimeUnit unit) {
		this.hashOpsTemplate.getOperations().expire(key, timeout, unit);
	}

	@Override
	public void storeUncmprsdValue(Object key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storeUncmprsdValueWithTTL(Object key, Object value,
			long timeout, TimeUnit unit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getUncmprsdValue(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getMultipleValues(List<Object> keys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMultipleValues(Map<Object, Object> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leftPush(Object key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rightPush(Object key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object leftPop(Object key, long timeout, TimeUnit unit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object rightPop(Object key, long timeout, TimeUnit unit) {
		// TODO Auto-generated method stub
		return null;
	}
}