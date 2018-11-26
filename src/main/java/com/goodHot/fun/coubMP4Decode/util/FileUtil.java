package com.goodHot.fun.coubMP4Decode.util;

import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * 文件及目录相关工具
 */
public class FileUtil {

    /**
     * 目标路径下(单一层级)，符合正则的所有文件列表
     *
     * @param dir   目标路径
     * @param regex 筛选文件名
     * @return
     */
    public File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            public boolean accept(File dir, String name) {
                // 如果没有后缀，直接过
                if (!name.contains(".")) {
                    return true;
                }
                return pattern.matcher(name).matches();
            }
        });
    }

    public File[] local(String path, final String regex) {
        return local(new File(path), regex);
    }

    /**
     * 递归遍历目标路径，对文件名符合正则的文件，做解码处理
     *
     * @param dir           目标路径
     * @param regex         匹配文件名
     * @param decodeHandler 解码操作
     */
    public void recurseDirsAndHandleFile(File dir, final String regex, DecodeHandler decodeHandler) {
        for (File file : local(dir, regex)) {
            if (file.isFile()) {
                decodeHandler.decode(file);
            } else {
                recurseDirsAndHandleFile(file, regex, decodeHandler);
            }
        }
    }

    public void recurseDirsAndHandleFile(String path, final String regex, DecodeHandler decodeHandler) {
        recurseDirsAndHandleFile(new File(path), regex, decodeHandler);
    }

    public void main(String[] args) {
        File file = new File("/Users/yanwenyuan/aCode4F/coubMP4Decode/src/main/resources");
//        System.out.println(JSON.toJSONString(file.list()));
//        System.out.println(JSON.toJSONString(file.listFiles()));

        System.out.println(JSON.toJSONString(local(file, "^(?!NICE_)[\\s\\S]*.mp4$")));
    }
}
