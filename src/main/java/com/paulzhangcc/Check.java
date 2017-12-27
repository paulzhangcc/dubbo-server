package com.paulzhangcc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author: Paul Zhang
 * @date: 16:21 2017/12/27
 */
public class Check {
    private static final Logger logger = LoggerFactory.getLogger(Check.class);
    public static void checkDuplicate(Class cls) {
        checkDuplicate(cls.getName().replace('.', '/') + ".class"
        );
    }
    public static void checkDuplicate(String path) {
        try {
            // 在ClassPath搜文件
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader()
            .getResources(path);
            Set files = new HashSet();
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (url != null) {
                    String file = url.getFile();
                    if (file != null && file.length() > 0) {
                        files.add(file);
                    }
                }
            }
// 如果有多个，就表示重复
            if (files.size() > 1) {
                logger.error("Duplicate class " + path + " in "
                        + files.size() + " jar " + files);
            }
        } catch (Throwable e) { // 防御性容错
            logger.error(e.getMessage(), e);
        }
    }
}
