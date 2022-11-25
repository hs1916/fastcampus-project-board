package com.study.projectboard;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class LoggerTest {


//    Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testLogException() {
        try {
            throw new RuntimeException("강제로 발생시킨 오류입니다");
        } catch (RuntimeException ex) {
            log.error("Error Occur={}", "강제", ex);
        }
    }
}
