```java
1.@ResponseBody 这个注解可以让我们将返回值放在response体内，而不是返回一个html页面，当我们在移动端比如Android、或者通过Ajax来访问服务端的数据的时候，就可以通过这个注解。 
2.@RequestBody 这个注解允许request的参数在request体中，而不是直接放在地址后面。 
3.@PathVariable 这个注解用来接收路径参数 
4.@RestController 这是一个组合注解，组合了@Controller和@ResponseBody两个，在开发中我们可以用@RestController这一个，也可以用后面两个，使用这个可以自动将一个对象转为xml或者json返回给客户端。

```
