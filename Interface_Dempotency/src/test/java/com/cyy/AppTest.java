package com.cyy;

import static org.junit.Assert.assertTrue;

import junit.framework.TestSuite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest {

    @Test
    public void test() {
        System.out.println("hello word");
    }
}
