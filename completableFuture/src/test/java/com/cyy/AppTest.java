package com.cyy;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Unit test for simpl
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {

    // 带返回值异步请求，默认线程池
    //public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier);
    @Test
    public void supplyAsync() {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("do something....");
            return "result";
        });
        //等待任务执行完成
        String s = cf.join();
        System.out.println("结果->" + s);
    }

    @Test
    public void supplyAsync1() {
        // 自定义线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("do something....");
            return "result";
        }, executorService);

        //等待子任务执行完成
        System.out.println("结果->" + cf.join());
    }

    //2. runAsync() 或 start() 可以用来执行并发任务，但是不带返回值。
    //runAsync() 可以用来在不支持通知的基于回调的语言中执行任务。
    // 不带返回值的异步请求，默认线程池
    //public static CompletableFuture<Void> runAsync(Runnable runnable)
    // 不带返回值的异步请求，可以自定义线程池
    // public static CompletableFuture<Void> runAsync(Runnable runnable, Executor executor)
    @Test
    public void runAsync() {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            System.out.println("do something....");
        });
        //等待任务执行完成
        System.out.println("结果->" + cf.join());
    }

    @Test
    public void runAsync1() {
        // 自定义线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            System.out.println("do something....");
        }, executorService);

        //等待任务执行完成
        System.out.println("结果->" + cf.join());
    }


    /*
     * 异步回调处理(有返回值)
     *从上面代码和测试结果我们发现thenApply和thenApplyAsync区别在于，使用thenApply方法时子任务与父任务使用的是同一个线程，
     *而thenApplyAsync在子任务中是另起一个线程执行任务，
     *并且thenApplyAsync可以自定义线程池，默认的使用ForkJoinPool.commonPool()线程池。
     * */
    @Test
    public void thenApplyAsync() {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });

        CompletableFuture<Integer> cf2 = cf1.thenApplyAsync((result) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            result += 2;
            return result;
        });
        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.join());
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.join());

    }

    @Test
    public void thenApply() {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });

        CompletableFuture<Integer> cf2 = cf1.thenApply((result) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            result += 2;
            return result;
        });
        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.join());
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.join());

    }

    //2.thenAccept和thenAcceptAsync(回调无返回值)
    @Test
    public void thenAccept() {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });

        CompletableFuture<Void> cf2 = cf1.thenAccept((result) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
        });

        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.join());
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.join());
    }

    @Test
    public void thenAcceptAsync() {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });

        CompletableFuture<Void> cf2 = cf1.thenAcceptAsync((result) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
        });

        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.join());
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.join());

    }


    /*
    * 2.thenRun和thenRunAsync
      thenRun表示某个任务执行完成后执行的动作，即回调方法，无入参，无返回值。
    * */
    @Test
    public void thenRun() {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });

        CompletableFuture<Void> cf2 = cf1.thenRun(() -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
        });

        //等待任务1执行完成
        System.out.println("cf1结果->" + cf1.join());
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.join());

    }

    //处理异常
    /*
     * 3.whenComplete和whenCompleteAsync
     * */

    @Test
    public void whenComplete() {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            int a = 1 / 0;
            return 1;
        });

        CompletableFuture<Integer> cf2 = cf1.whenComplete((result, e) -> {
            System.out.println("上个任务结果：" + result);
            System.out.println("上个任务抛出异常：" + e);
            System.out.println(Thread.currentThread() + " cf2 do something....");
        });

//        //等待任务1执行完成
//        System.out.println("cf1结果->" + cf1.get());
//        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.join());
    }

    // 跟whenComplete基本一致，区别在于handle的回调方法有返回值
    @Test
    public void handle() {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            // int a = 1/0;
            return 1;
        });

        CompletableFuture<Integer> cf2 = cf1.handle((result, e) -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            System.out.println("上个任务结果：" + result);
            System.out.println("上个任务抛出异常：" + e);
            return result + 2;
        });
        //等待任务2执行完成
        System.out.println("cf2结果->" + cf2.join());

    }

    //thenCombine
    @Test
    public void thenCombine() {
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf1 do something....");
            return 1;
        });

        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread() + " cf2 do something....");
            return 2;
        });

        CompletableFuture<Integer> cf3 = cf1.thenCombine(cf2, (a, b) -> {
            System.out.println(Thread.currentThread() + " cf3 do something....");
            return a + b;
        });

        System.out.println("cf3结果->" + cf3.join());
    }

}
