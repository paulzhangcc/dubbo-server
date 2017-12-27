package com.paulzhangcc.sharing;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author paul
 * @date 2017/12/27
 */
@Configuration
public class SharingSpringConfig {
    /**
     * 图形验证码配置类
     *
     * @return
     */
    @Bean
    public DefaultKaptcha defaultKaptcha() {
        //http://blog.csdn.net/elephantboy/article/details/52795309
        Properties properties = new Properties();
        //图片边框，合法值:yes , no  默认值:yes
        properties.setProperty("kaptcha.border", "yes");
        //边框颜色，合法值： r,g,b (and optional alpha) 或者 white,black,blue. 默认值:black
        properties.setProperty("kaptcha.border.color", "black");
        //边框厚度，合法值：>0   默认值:1
        properties.setProperty("kaptcha.border.thickness", "1");
        //图片宽 默认值:200
        properties.setProperty("kaptcha.image.width", "100");
        //图片高 默认值:50
        properties.setProperty("kaptcha.image.height", "50");
        //图片实现类      默认值:com.google.code.kaptcha.impl.DefaultKaptcha
        //properties.setProperty("kaptcha.producer.impl","");
        //文本实现类      默认值:com.google.code.kaptcha.impl.DefaultTextCreator
        //properties.setProperty("kaptcha.textproducer.impl","");

        //文本集合，验证码值从此集合中获取0123456789ABCEFGHIJKLMNOPQRSTUVWXYZ
        properties.setProperty("kaptcha.textproducer.char.string", "02345689");
        //验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        //字体   默认值:
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        //字体颜色，合法值： r,g,b  或者 white,black,blue.
        properties.setProperty("kaptcha.textproducer.font.color", "black");
        //字体大小
        properties.setProperty("kaptcha.textproducer.font.size", "40");
        //文字间隔
        properties.setProperty("kaptcha.textproducer.char.space", "5");

        //properties.setProperty("kaptcha.session.key", "code");
//        图片样式：
//        水纹com.google.code.kaptcha.impl.WaterRipple
//        鱼眼com.google.code.kaptcha.impl.FishEyeGimpy
//        阴影com.google.code.kaptcha.impl.ShadowGimpy
        properties.setProperty("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.WaterRipple");
        //干扰 颜色，合法值： r,g,b 或者 white,black,blue.
        properties.setProperty("kaptcha.noise.color", "black");
        //干扰实现类
        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.DefaultNoise");
        //背景颜色渐变，开始颜色
        properties.setProperty("kaptcha.background.clear.from", "white");
        //背景颜色渐变， 结束颜色
        properties.setProperty("kaptcha.background.clear.to", "white");

        com.google.code.kaptcha.util.Config config = new com.google.code.kaptcha.util.Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

}
