package com.cyy;

import static org.junit.Assert.assertTrue;

import com.cyy.domain.User;
import com.cyy.domain.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {
    @Test
    public void getStream() {
        User user = new User();
        user.setId(1);
        user.setName("cyy");

        User user1 = new User();
        user1.setId(2);
        user1.setName("cyy1");

        User user2 = new User();
        user2.setId(3);
        user2.setName("cyy2");
        ArrayList<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(user, user1, user2));
        User user5 = new User();
        user5.setId(1);
        user5.setName("cyy5");

        User user3 = new User();
        user3.setId(1);
        user3.setName("cyy3");

        User user4 = new User();
        user4.setId(2);
        user4.setName("cyy4");
        ArrayList<User> users1 = new ArrayList<>();
        users1.addAll(Arrays.asList(user3, user4, user5));

        User user6 = new User();
        user6.setId(1);
        user6.setName("cyy6");

        User user7 = new User();
        user7.setId(2);
        user7.setName("cyy7");

        User user8 = new User();
        user8.setId(3);
        user8.setName("cyy8");
        ArrayList<User> users2 = new ArrayList<>();
        users2.addAll(Arrays.asList(user6, user7, user8));
        List<UserDto> userDtos = IntStream.range(0, Math.min(users.size(), Math.min(users1.size(), users2.size())))
                .filter(i -> !users1.get(i).getName().equals(users2.get(i).getName()) &&
                        !users1.get(i).getName().equals(users2.get(i).getName()))
                .mapToObj(i -> {
                    User user9 = users.get(i);
                    User user10 = users1.get(i);
                    User user11 = users2.get(i);
                   return
                           new UserDto()
                            .builder()
                            .id(user9.getId())
                            .name(user9.getName())
                            .name1(user10.getName())
                            .name2(user11.getName())
                            .build();

                })
                .distinct()
                .collect(Collectors.toList());
        userDtos.forEach(userDto -> System.out.println(userDto));
    }


    @Test
    public void testFindAllOrderedByName() throws Exception {

        ExecutorService es2 = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            es2.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "正在执行任务");
                }
            });
        }

    }
}
