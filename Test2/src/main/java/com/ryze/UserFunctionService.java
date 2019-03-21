package com.ryze;

/**
 * Created by xueLai on 2019/3/21.
 */

public class UserFunctionService {
    private FunctionService functionService;


    public FunctionService getFunctionService() {
        return functionService;
    }

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public String sayHello(String word){
        return functionService.sayHello(word);
    }
}
