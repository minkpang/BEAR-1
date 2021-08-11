package com.zootopia.bear.User.controller;

import com.zootopia.bear.User.domain.User;
import com.zootopia.bear.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        userService.kakaoLogout((String)session.getAttribute("accessToken"));  //access_Token 부여
        //session 초기화 설정
        session.removeAttribute("accessToken");
        session.removeAttribute("userId");
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/myInfo")
    public ResponseEntity<?> getMyInfo(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.getUser(userId).get();
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestParam User user){
        if(userService.updateUser(user)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam User user){
        if(userService.deleteUser(user)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }

}