package com.goodHot.fun.coubMP4Decode;

import com.goodHot.fun.coubMP4Decode.util.CoubDecodeHandlerImplement;
import com.goodHot.fun.coubMP4Decode.util.DecodeHandler;
import com.goodHot.fun.coubMP4Decode.util.Download;
import com.goodHot.fun.coubMP4Decode.util.FileUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoConfigure {

    @Bean
    @ConditionalOnMissingBean
    FileUtil fileUtil() {
        return new FileUtil();
    }

    @Bean
    @ConditionalOnMissingBean
    DecodeHandler decodeHandler() {
        return new CoubDecodeHandlerImplement();
    }

    @Bean
    @ConditionalOnMissingBean
    Download download() {
        return new Download();
    }

}
