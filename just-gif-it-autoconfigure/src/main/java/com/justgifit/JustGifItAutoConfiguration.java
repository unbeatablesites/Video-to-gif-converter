package com.justgifit;

import com.madgag.gif.fmsware.AnimatedGifEncoder;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;

@Configuration
@ConditionalOnClass({FFmpegFrameGrabber.class, AnimatedGifEncoder.class})
public class JustGifItAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "com.justgifit",name = "create=result-dir")
    private Boolean createResultDir() {
        File gifFolder = new File(gifLocation);
        if (!gifFolder.exists()) {
            gifFolder.mkdir();
        }
        return  true;
    }

    @Value("${multipart.location}/gif/")
    private String gifLocation;

    @Bean
    @ConditionalOnMissingBean(uzoka.frank.io.services.VideoDecoderService.class)
    public uzoka.frank.io.services.VideoDecoderService videoDecoderService(){
        return new uzoka.frank.io.services.VideoDecoderService();
    }

    @Bean
    @ConditionalOnMissingBean(uzoka.frank.io.services.GifEncoderService.class)
    public uzoka.frank.io.services.GifEncoderService gifEncoderService(){
        return new uzoka.frank.io.services.GifEncoderService();
    }

    @Bean
    @ConditionalOnMissingBean(uzoka.frank.io.services.ConverterService.class)
    public uzoka.frank.io.services.ConverterService converterService(){
        return new uzoka.frank.io.services.ConverterService();
    }

    @Configuration
    @ConditionalOnWebApplication
    public static class WebConfiguration{

        @Value("${multipart.location}/gif/")
        private String gifLocation;

}

}
