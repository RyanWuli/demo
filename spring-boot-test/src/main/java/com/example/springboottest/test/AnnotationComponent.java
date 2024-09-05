package com.example.springboottest.test;

import com.example.springboottest.annotation.TAM;
import com.example.springboottest.annotation.TAT;
import org.springframework.stereotype.Component;

/**
 * @Author: Ryan
 * @Date: 2024/6/18 10:38
 * @Version: 1.0
 * @Description: add the description
 */
@TAT
@Component
public class AnnotationComponent {

    @TAM
    public void method() {
        System.out.println("run AnnotationComponent method");
    }

}
