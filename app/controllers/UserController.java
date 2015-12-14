package controllers;

import models.User;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import java.util.List;

public class UserController extends Controller {
    @Transactional
    public static Result registerUser(){
        Http.RequestBody body = request().body();
        User user = Json.fromJson(body.asJson(), User.class);
        List<User> list = JPA.em().createQuery("select u from User u where u.username = :username",User.class)
                .setParameter("username",user.getUsername())
                .getResultList();
        if (list.size() > 0){
            return badRequest("Registration error");
        }else {
            JPA.em().persist(user);
            return ok("Registration finished successfully");
        }
    }

    @Transactional
    public static Result login(){
        Http.RequestBody body = request().body();
        User user = Json.fromJson(body.asJson(), User.class);
        List<User> list = JPA.em().createQuery("select u from User u where u.username = :username and " +
                "u.password = :password",User.class)
                .setParameter("username",user.getUsername()).setParameter("password",user.getPassword())
                .getResultList();
        if (list.size() > 0){
            response().setCookie("username",list.get(0).getUsername());
            return ok("/search");
        }else {
            return badRequest("Name or password is wrong");
        }
    }
}
