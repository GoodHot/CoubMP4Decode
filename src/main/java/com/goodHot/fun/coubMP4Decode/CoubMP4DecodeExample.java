package com.goodHot.fun.coubMP4Decode;

import com.goodHot.fun.coubMP4Decode.util.CoubDecodeHandlerImplement;
import com.goodHot.fun.coubMP4Decode.util.FileUtil;

/**
 * 对coub转码
 */
public class CoubMP4DecodeExample {
    public static void main(String[] args) {
        // 处理『不以 NICE_ 开头的，以.mp4结尾的所有文件』
        new FileUtil().recurseDirsAndHandleFile("/Users/yanwenyuan/aCode4F/coubMP4Decode/src/main/resources/",
                "^(?!NICE_)[\\s\\S]*.mp4$",
                new CoubDecodeHandlerImplement());
    }
}