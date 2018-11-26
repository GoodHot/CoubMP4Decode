package com.goodHot.fun.coubMP4Decode;

import com.goodHot.fun.coubMP4Decode.util.Download;

public class DownloadExample {

    public static void main(String[] args) {
        String url = "https://coubsecure-s.akamaihd.net/get/b100/p/coub/simple/cw_file/ab49b1c9d79/f786820f073ab03822511/muted_mp4_med_size_1542278618_muted_med.mp4";
        String filePath = "/Users/yanwenyuan/aCode4F/coubMP4Decode/src/main/resources/muted_mp4_med_size_1542278618_muted_med.mp4";
        new Download().downloadFromUrl(url, filePath);
    }
}
