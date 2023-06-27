package com.cyy;
import java.util.stream.LongStream;

/**
 * @author:CYY
 * @create: 2023-06-19 09:18:32
 * @Description:
 */
public class TestThreadLocal {
    public static ThreadLocal<String> local = new ThreadLocal<>();
    public static void main(String[] args) {
        try {
            LongStream.range(100000000, 100000005)
                    .forEach(a -> new Thread(()-> {
                        local.set(Thread.currentThread().getName() + "-" + a);
                        System.out.println("线程名称：" + Thread.currentThread().getName() + ", local: " + local.get());
                    }).start());
        } finally {
            local.remove();
        }


    }

}
