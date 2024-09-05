package com.zxw.demo.io;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Arrays;

/**
 * @Author: Ryan
 * @Date: 2024/6/24 17:25
 * @Version: 1.0
 * @Description: 字节流
 *                  PipedInputStream, PipedOutputStream:管道输入输出流，可以不同线程绑定执行
 *                  还有其它多种类型待补充
 */
@Slf4j
public class ByteStream {

    /**
     * 字节数组输入流
     *
     * @param bytes 字节数组（从此输入）
     */
    public static void byteArrayInput(byte[] bytes) {
        if (null == bytes || bytes.length == 0) {
            log.warn("字节数组为空！！！");
            return;
        }

        ByteArrayInputStream byteArrayInputStream = null;

        try {
            byteArrayInputStream = new ByteArrayInputStream(bytes);

            int i = 1;

            while (byteArrayInputStream.available() > 0) {
                log.info("第" + i + "次读取，内容为：" + byteArrayInputStream.read());
            }
        } finally {
            if (null != byteArrayInputStream) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 字节数组输出流
     *
     */
    public static byte[] byteArrayOutput(byte[] b) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            byteArrayOutputStream.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return byteArrayOutputStream.toByteArray();
    }

    /**
     * 文件输入流（单字节读取）
     *
     * @param filePath 文件路径
     * @return 文件字节数组
     */
    public static byte[] fileInput(String filePath) {
        long start = System.currentTimeMillis();

        if (StringUtils.isBlank(filePath)) {
            return null;
        }

        int l;
        int n = 1;
        byte[] bytes = null;
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(filePath);

            if (fileInputStream.available() == -1) {
                return null;
            } else {
                // 每次读取一个字节（这里不能默认长度，否则文件字节数组可能会有多余的空值0，导致文件输出有NUL|）
                bytes = new byte[1];
            }

            while ((l = fileInputStream.read()) != -1) {
                log.info("第" + n + "次读取：" + l);

                if (n > bytes.length) {
                    // 这里每次字节数组+1，防止过多增长字节数组有空值，导致文件输出有NUL|
                    bytes = grow(bytes, bytes.length + 1);
                }

                bytes[n - 1] = (byte) l;
                n++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fileInputStream) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long end = System.currentTimeMillis();

        log.info("-----> 耗时：{}ms", end - start);

        return bytes;
    }

    /**
     * 文件输出流
     *
     * @param filePath 输出文件位置
     * @param bs 输出文件字节数组
     */
    public static void fileOutput(String filePath, byte[] bs) {
        if (bs.length == 0) {
            return;
        }

        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write(bs);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fileOutputStream) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 文件输入输出流（buffer）
     * @param from
     * @param to
     */
    public static void fileInOutBuffered(String from, String to) {
        if (StringUtils.isAnyBlank(from, to)) {
            log.info("源文件和生成文件地址都不能为空！");
            return;
        }

        FileInputStream fis = null;
        FileOutputStream fos = null;
        byte[] buffer = new byte[256];
        int len;
        int time = 1;

        try {
            fis = new FileInputStream(from);
            fos = new FileOutputStream(to);

            // read 方法读取了多少个字节会返回
            while ((len = fis.read(buffer)) != -1) {
                log.info("第{}次读写...len:{}, 数据：{}", time, len, buffer);

                // 这里可以传入下标区间，写入读取的长度，防止 buffer 没有读满的情况下写入空值 NUL|
                fos.write(buffer, 0, len);
                time++;
            }
        } catch (IOException e) { // IOException 是 FileNotFoundException 的父类（写一个父类就好）
            e.printStackTrace();
        } finally {
            try {
                if (null != fis) {
                    fis.close();
                }

                if (null != fos) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 管道输入输出流
     *
     * @param str 需要传递的字符串信息
     */
    public static void pipedInOut(String str) {
        log.info("origin str:{}", str);

        if (StringUtils.isBlank(str)) {
            return;
        }

        PipedInputStream pipedInput = new PipedInputStream();
        PipedOutputStream pipedOutput = new PipedOutputStream();
        ByteArrayInputStream bai = new ByteArrayInputStream(str.getBytes());

        try {
            pipedOutput.connect(pipedInput);

            // 生产者 out
            new Thread(() -> {

                int len;
                int time = 1;
                byte[] bs = new byte[256];

                try {
                    while ((len = bai.read(bs)) != -1) {
                        log.info("第{}次写入数据长度:{}", time, len);
                        pipedOutput.write(bs, 0, len);
                        time++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        // 必须写完成就关闭，不然读取会报错
                        pipedOutput.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }, "Thread-out").start();

            // 消费者 in
            new Thread(() -> {

                // 每次读取的字符长度
                int len;
                // 读取次数
                int time = 1;
                // 读取的所有字节汇总
                byte[] sumBytes = new byte[0];
                // 字符数组缓存
                byte[] bs = new byte[256];

                try {
                    while ((len = pipedInput.read(bs)) != -1) {
                        log.info("pipedInput 第{}次读取数据 len:{}", time, len);
                        time++;
                        sumBytes = sumBytes(bs, len, sumBytes);
                    }
                    String s = new String(sumBytes);
                    log.info("pipedInput read res:{}", s);
                    log.info("pipedInput read res is right:{}", StringUtils.equals(s, str));
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        pipedInput.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }, "Thread-in").start();

            // 这里阻塞一下，不然会关闭流，正常使用需要生产者和消费者引用持有流对象，这里 demo 不想新建那么多对象所以写一个方法了
            Thread.sleep(10000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 汇总字节到数组
     * @param bs 字节信息
     * @param len 读取长度
     * @param sumBytes 汇总后数组
     * @return 返回汇总后新数组
     */
    private static byte[] sumBytes(byte[] bs, int len, byte[] sumBytes) {
        byte[] newByte = grow(sumBytes, sumBytes.length + len);
        for (int i = 0; i < len; i++) {
            newByte[sumBytes.length + i] = bs[i];
        }
        return newByte;
    }

    /**
     * bytes 数组扩容并保留原数据
     *
     * @param bytes 原字节数组
     * @return 新的字节数组
     */
    private static byte[] grow(byte[] bytes, int newLength) {
        return Arrays.copyOf(bytes, newLength);
    }

}
