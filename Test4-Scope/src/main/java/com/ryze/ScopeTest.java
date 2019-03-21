package com.ryze;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by xueLai on 2019/3/21.
 */
@Component
//@Scope("singleton")
@Scope("prototype")
public class ScopeTest {
}
