package main.java.com.youliao.study.boot_redis.boot_redis01.src.main.java.com.youliao.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * @Author Dali
 * @Date 2021/6/6 12:33
 * @Version 1.0
 * @Description: boot整合redis搭建超卖程序 https://www.bilibili.com/video/BV1Hy4y1B78T?p=50&spm_id_from=pageDriver
 */
@RestController
public class GoodController {

    public static final String REDIS_LOCK = "atguiguLock";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private Redisson redisson;

    @GetMapping("/buy_goods")
    public String buy_Goods() throws Exception {

        String value = UUID.randomUUID().toString() + Thread.currentThread().getName();

        RLock redissonLock = redisson.getLock(REDIS_LOCK);
        redissonLock.lock();

        try {
            Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(REDIS_LOCK, value, 10L, TimeUnit.SECONDS);//相当于redis的setNX命令 保证原子性
/*//            stringRedisTemplate.expire(REDIS_LOCK, 10L, TimeUnit.SECONDS);
            if (!flag) {
                return "抢锁失败";
            }*/
            String result = stringRedisTemplate.opsForValue().get("goods:001"); //get key === 看看库存的数量够不够
            int goodsNumber = result == null ? 0 : Integer.parseInt(result);
            if (goodsNumber > 0) {
                int realNumber = goodsNumber - 1;
                stringRedisTemplate.opsForValue().set("goods:001", realNumber + "");
                System.out.println("你已经成功秒杀商品，此时还剩余：" + realNumber + "件" + "\t 服务器端口：" + serverPort);

                return "你已经成功秒杀商品，此时还剩余：" + realNumber + "件" + "\t 夫区其端口：" + serverPort;
            } else {
                System.out.println("商品已经售罄/活动结束/调用超时，欢迎下次光临" + "\t 服务器端口:" + serverPort);
            }
            return "商品已经售罄/活动结束/调用超时，欢迎下次光临" + "\t 服务器端口:" + serverPort;
        } finally {
//            if (stringRedisTemplate.opsForValue().get(REDIS_LOCK).equalsIgnoreCase(value)) {
//                stringRedisTemplate.delete(REDIS_LOCK);
//            }
            /*while (true) {
                stringRedisTemplate.watch(REDIS_LOCK); //加事务，乐观锁
                if (value.equalsIgnoreCase(stringRedisTemplate.opsForValue().get(REDIS_LOCK))) {
                    stringRedisTemplate.setEnableTransactionSupport(true);
                    stringRedisTemplate.multi();//开始事务
                    stringRedisTemplate.delete(REDIS_LOCK);
                    List<Object> list = stringRedisTemplate.exec();
                    if (list == null) {  //如果等于null，就是没有删掉，删除失败，再回去while循环那再重新执行删除
                        continue;
                    }
                }
                //如果删除成功，释放监控器，并且breank跳出当前循环
                stringRedisTemplate.unwatch();
                break;
            }*/

            /*Jedis jedis = RedisUtils.getJedis();

            String script = "if redis.call('get', KEYS[1]) == ARGV[1]" + "then "
                    + "return redis.call('del', KEYS[1])" + "else " + "  return 0 " + "end";
            try {
                Object result = jedis.eval(script, Collections.singletonList(REDIS_LOCK), Collections.singletonList(value));
                if ("1".equals(result.toString())) {
                    System.out.println("------del REDIS_LOCK_KEY success");
                } else {
                    System.out.println("------del REDIS_LOCK_KEY error");
                }
            } finally {
                if (null != jedis) {
                    jedis.close();
                }
            }*/
            //还在持有锁的状态，并且是当前线程持有的锁再解锁
            if (redissonLock.isLocked() && redissonLock.isHeldByCurrentThread()) {
                redissonLock.unlock();
            }
        }

    }
}
