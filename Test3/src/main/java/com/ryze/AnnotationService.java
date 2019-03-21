package com.ryze;


import org.springframework.stereotype.Service;

/**
 * Created by xueLai on 2019/3/21.
 */
@Service
public class AnnotationService {
    @LogAspect(name="add",action=LogAspect.Enumlog.ADD)
    public void add(){
        System.out.println("add...");
    }
    @LogAspect(name="delete",action=LogAspect.Enumlog.DELETE)
    public void delete(){
        System.out.println("delete...");
    }

    @LogAspect(name="update",action=LogAspect.Enumlog.UPDATE)
    public void update(){
        System.out.println("update...");
    }

    @LogAspect(name="select",action=LogAspect.Enumlog.SELECT)
    public void select(){
        System.out.println("select...");
    }
}
