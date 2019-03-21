package com.ryze;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * Created by xueLai on 2019/3/21.
 */
@Service
public class MethodService {

    public void add() {
        System.out.println("method-add()");
    }
}
