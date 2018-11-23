package com.goodHot.fun.coubMP4Decode.util;

import java.io.File;

/**
 * 解码视频
 */
public interface DecodeHandler {

    /**
     * 解码文件（并不生成新文件）
     * @param file
     */
    void decode(File file);
}
