package com.goodHot.fun.coubMP4Decode.util;

import java.io.*;
import java.net.URL;

public class Download {

    public static final int BUFFER_SIZE = 1024;
    public static final int EMPTY_BUFFER_FLAG = -1;

    public void downloadFromUrl(String url, String filePath) {
        try (InputStream bufferIn = new BufferedInputStream(new URL(url).openStream());
             ByteArrayOutputStream bufferOut = new ByteArrayOutputStream();
             FileOutputStream fileOutputStream = new FileOutputStream(filePath);) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bufferCurrentSize = 0;
            while (EMPTY_BUFFER_FLAG != (bufferCurrentSize = bufferIn.read(buffer))) {
                bufferOut.write(buffer, 0, bufferCurrentSize);
            }
            bufferIn.close();
            bufferOut.close();
            byte[] response = bufferOut.toByteArray();

            fileOutputStream.write(response);

        } catch (IOException e) {

        }
    }

}
