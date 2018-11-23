package com.goodHot.fun.coubMP4Decode.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CoubDecodeHandlerImplement implements DecodeHandler {
    public void decode(File file) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0);
            randomAccessFile.write(new byte[]{0x00, 0x00}, 0, 2);
            file.renameTo(new File(file.getParent() + "/NICE_" + file.getName()));
            randomAccessFile.close();
        } catch (IOException e) {
            // TODO: 2018/11/23 log
        }
    }

    public static void main(String[] args) {
        new CoubDecodeHandlerImplement().decode(new File("/Users/yanwenyuan/aCode4F/coubMP4Decode/src/main/resources/muted_mp4_big_size_1541182196_muted_big.mp4"));
    }
}
