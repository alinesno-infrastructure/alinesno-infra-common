package com.alinesno.infra.common.core.cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.redisson.api.*;

import java.time.Duration;
import java.util.function.Consumer;

/**
 * 单元测试类，用于测试 RedisUtils 类的各个方法。
 *
 * 作者：luoxiaodong
 * 版本：1.0.0
*/
public class RedisUtilsTest {

    private RedissonClient redissonClient;
    private RBucket<Object> bucket;
    private RList<Object> list;
    private RSet<Object> set;
    private RTopic topic;

    @BeforeEach
    public void setUp() {
        redissonClient = Mockito.mock(RedissonClient.class);
        bucket = Mockito.mock(RBucket.class);
        list = Mockito.mock(RList.class);
        set = Mockito.mock(RSet.class);
        topic = Mockito.mock(RTopic.class);

        Mockito.when(redissonClient.getBucket(Mockito.anyString())).thenReturn(bucket);
        Mockito.when(redissonClient.getList(Mockito.anyString())).thenReturn(list);
        Mockito.when(redissonClient.getSet(Mockito.anyString())).thenReturn(set);
        Mockito.when(redissonClient.getTopic(Mockito.anyString())).thenReturn(topic);
    }

    @Test
    @DisplayName("测试 rateLimiter 方法")
    public void testRateLimiter() {
        RRateLimiter rateLimiter = Mockito.mock(RRateLimiter.class);
        Mockito.when(redissonClient.getRateLimiter(Mockito.anyString())).thenReturn(rateLimiter);
        Mockito.when(rateLimiter.tryAcquire()).thenReturn(true);
        Mockito.when(rateLimiter.availablePermits()).thenReturn(10L);

        long result = RedisUtils.rateLimiter("key", RateType.OVERALL, 10, 1);
        Assertions.assertEquals(10L, result, "限流失败");
    }

    @Test
    @DisplayName("测试 publish 方法")
    public void testPublish() {
        String channelKey = "channel";
        String msg = "message";
        Consumer<String> consumer = Mockito.mock(Consumer.class);

        RedisUtils.publish(channelKey, msg, consumer);

        Mockito.verify(topic).publish(msg);
        Mockito.verify(consumer).accept(msg);
    }

    @Test
    @DisplayName("测试 subscribe 方法")
    public void testSubscribe() {
        String channelKey = "channel";
        Class<String> clazz = String.class;
        Consumer<String> consumer = Mockito.mock(Consumer.class);

        RedisUtils.subscribe(channelKey, clazz, consumer);

        Mockito.verify(topic).addListener(clazz, Mockito.any());
    }

    @Test
    @DisplayName("测试 setCacheObject 方法")
    public void testSetCacheObject() {
        String key = "key";
        Object value = new Object();

        RedisUtils.setCacheObject(key, value);

        Mockito.verify(bucket).set(value);
    }

    @Test
    @DisplayName("测试 setCacheObject 方法（保留TTL有效期）")
    public void testSetCacheObjectWithTtl() {
        String key = "key";
        Object value = new Object();
        long timeToLive = 90L;

        Mockito.when(bucket.remainTimeToLive()).thenReturn(timeToLive);

        RedisUtils.setCacheObject(key, value, true);

        Mockito.verify(bucket).setAndKeepTTL(value);
    }

    @Test
    @DisplayName("测试 setCacheObject 方法（指定Duration）")
    public void testSetCacheObjectWithDuration() {
        String key = "key";
        Object value = new Object();
        Duration duration = Duration.ofSeconds(60);

        RBatch batch = Mockito.mock(RBatch.class);
        RBucketAsync<Object> bucketAsync = Mockito.mock(RBucketAsync.class);
        Mockito.when(redissonClient.createBatch()).thenReturn(batch);
        Mockito.when(batch.getBucket(Mockito.anyString())).thenReturn(bucketAsync);

        RedisUtils.setCacheObject(key, value, duration);

        Mockito.verify(bucketAsync).setAsync(value);
        Mockito.verify(bucketAsync).expireAsync(duration);
        Mockito.verify(batch).execute();
    }

    @Test
    @DisplayName("测试 setObjectIfAbsent 方法")
    public void testSetObjectIfAbsent() {
        String key = "key";
        Object value = new Object();
        Duration duration = Duration.ofSeconds(60);

        Mockito.when(bucket.setIfAbsent(Mockito.any(), Mockito.any())).thenReturn(true);

        boolean result = RedisUtils.setObjectIfAbsent(key, value, duration);
        Assertions.assertTrue(result, "setObjectIfAbsent 返回值错误");
    }

    @Test
    @DisplayName("测试 addObjectListener 方法")
    public void testAddObjectListener() {
        String key = "key";
        ObjectListener listener = Mockito.mock(ObjectListener.class);

        RedisUtils.addObjectListener(key, listener);

        Mockito.verify(bucket).addListener(listener);
    }

    @Test
    @DisplayName("测试 expire 方法（超时时间为秒）")
    public void testExpireWithSeconds() {
        String key = "key";
        long timeout = 60L;

        boolean result = RedisUtils.expire(key, timeout);
        Assertions.assertTrue(result, "expire 返回值错误");

        Mockito.verify(bucket).expire(Duration.ofSeconds(timeout));
    }

    @Test
    @DisplayName("测试 expire 方法（指定Duration）")
    public void testExpireWithDuration() {
        String key = "key";
        Duration duration = Duration.ofSeconds(60);

        boolean result = RedisUtils.expire(key, duration);
        Assertions.assertTrue(result, "expire 返回值错误");

        Mockito.verify(bucket).expire(duration);
    }

    @Test
    @DisplayName("测试 getCacheObject 方法")
    public void testGetCacheObject() {
        String key = "key";
        Object value = new Object();

        Mockito.when(bucket.get()).thenReturn(value);

        Object result = RedisUtils.getCacheObject(key);
        Assertions.assertEquals(value, result, "getCacheObject 返回值错误");
    }

    @Test
    @DisplayName("测试 getTimeToLive 方法")
    public void testGetTimeToLive() {
        String key = "key";
        long timeToLive = 60L;

        Mockito.when(bucket.remainTimeToLive()).thenReturn(timeToLive);

        long result = RedisUtils.getTimeToLive(key);
        Assertions.assertEquals(timeToLive, result, "getTimeToLive 返回值错误");
    }

    @Test
    @DisplayName("测试 deleteObject 方法")
    public void testDeleteObject() {
        String key = "key";

        boolean result = RedisUtils.deleteObject(key);
        Assertions.assertTrue(result, "deleteObject 返回值错误");

        Mockito.verify(bucket).delete();
    }

//    @Test
//    @DisplayName("测试 deleteObjects 方法")
//    public void testDeleteObjects() {
//        List<String> keys = Arrays.asList("key1", "key2", "key3");
//
//        RedisUtils.deleteObjects(keys);
//
//        Mockito.verify(bucket, Mockito.times(3)).delete();
//    }
//
//    @Test
//    @DisplayName("测试 addToSet 方法")
//    public void testAddToSet() {
//        String key = "key";
//        Object[] values = {"value1", "value2", "value3"};
//
//        RedisUtils.addToSet(key, values);
//
//        Mockito.verify(set).addAll(Arrays.asList(values));
//    }
//
//    @Test
//    @DisplayName("测试 removeFromSet 方法")
//    public void testRemoveFromSet() {
//        String key = "key";
//        Object[] values = {"value1", "value2", "value3"};
//
//        RedisUtils.removeFromSet(key, values);
//
//        Mockito.verify(set).removeAll(Arrays.asList(values));
//    }
//
//    @Test
//    @DisplayName("测试 getSet 方法")
//    public void testGetSet() {
//        String key = "key";
//        Set<Object> expectedSet = Collections.singleton("value");
//
//        Mockito.when(set.readAll()).thenReturn(expectedSet);
//
//        Set<Object> resultSet = RedisUtils.getSet(key);
//        Assertions.assertEquals(expectedSet, resultSet, "getSet 返回值错误");
//    }
//
//    @Test
//    @DisplayName("测试 addToList 方法")
//    public void testAddToList() {
//        String key = "key";
//        Object[] values = {"value1", "value2", "value3"};
//
//        RedisUtils.addToList(key, values);
//
//        Mockito.verify(list).addAll(Arrays.asList(values));
//    }
//
//    @Test
//    @DisplayName("测试 removeFromList 方法")
//    public void testRemoveFromList() {
//        String key = "key";
//        Object[] values = {"value1", "value2", "value3"};
//
//        RedisUtils.removeFromList(key, values);
//
//        Mockito.verify(list).removeAll(Arrays.asList(values));
//    }
//
//    @Test
//    @DisplayName("测试 getList 方法")
//    public void testGetList() {
//        String key = "key";
//        List<Object> expectedList = Collections.singletonList("value");
//
//        Mockito.when(list.readAll()).thenReturn(expectedList);
//
//        List<Object> resultList = RedisUtils.getList(key);
//        Assertions.assertEquals(expectedList, resultList, "getList 返回值错误");
//    }
}
