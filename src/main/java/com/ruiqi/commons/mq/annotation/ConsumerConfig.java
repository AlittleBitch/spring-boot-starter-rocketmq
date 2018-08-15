package com.ruiqi.commons.mq.annotation;

import com.ruiqi.commons.mq.enums.ConsumeMode;
import com.ruiqi.commons.mq.enums.ListenerType;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;

import java.lang.annotation.*;

/**
 * 用于在实现了com.ruiqi.commons.mq.receive.ConcurrentlyMessageListener.consume方法头上添加
 *
 * @author ShawnShoper
 * @date 2018/7/26 11:52
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ConsumerConfig {
    String topic() default "DEFAULT";

    String tags();

    ListenerType listenerType() default ListenerType.Concurrently;

    ConsumeFromWhere consumeFromWhere() default ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET;

    //    boolean autoCommit() default true;
    ConsumeMode consumeMode() default ConsumeMode.CONCURRENTLY;
}