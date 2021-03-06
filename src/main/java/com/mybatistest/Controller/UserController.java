package com.mybatistest.Controller;

import com.mybatistest.Controller.baseClass.BaseController;
import com.mybatistest.common.baseClass.JsonResult;
import com.mybatistest.domain.User;
import com.mybatistest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * Created by zhang_jian on 2017/12/15.
 */
@RestController
public class UserController extends BaseController{

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getAllInfo")
    public @ResponseBody JsonResult getAllInfo() {
        JsonResult jsonResult = new JsonResult();
        List<User> users = userService.selectAllUserInfo();
        jsonResult.setResult(users);
        jsonResult.setSuccessful();
        return jsonResult;
    }

    @RequestMapping(value = "/getUserInfo")
    public @ResponseBody JsonResult getUserInfo(@RequestParam(value = "username") String username) {
        JsonResult jsonResult = new JsonResult();
        User user = new User();
        user.setUsername(username);
        String responseData = user.toString();
        try {
            user = userService.selectUserInfo(user);
            responseData = user.toString();
            jsonResult.setResult(responseData);
            jsonResult.setSuccessful();
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            jsonResult.setFailure();
        }
        return jsonResult;
    }

    @RequestMapping(value = "/register")
    public @ResponseBody JsonResult register(@RequestParam(value = "username") String username,
                @RequestParam(value = "phone") String phone,
                @RequestParam(value = "address",required = false) String address,
                @RequestParam(value = "sex") String sex,
                @RequestParam(value = "email", required = false) String email,
                @RequestParam(value = "password") String password) {
        JsonResult jsonResult = new JsonResult();
        User user = new User();
        user.setUsername(username);
        user.setPhone(phone);
        user.setAddress(address);
        user.setSex(sex);
        user.setEmail(email);
        user.setPassword(password);
        try {
            if (userService.insertNewUserInfo(user)) jsonResult.setSuccessful();
            else jsonResult.setFailure();
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            jsonResult.setFailure();
        }
        return jsonResult;
    }

    @RequestMapping(value = "/removeUser")
    public @ResponseBody JsonResult removeUser(@RequestParam(value = "username") String username) {
        JsonResult jsonResult = new JsonResult();
        User user = new User();
        user.setUsername(username);
        try {
            if (userService.deleteUserInfo(user)) jsonResult.setSuccessful();
            else jsonResult.setFailure();
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            jsonResult.setFailure();
        }
        return jsonResult;
    }

    @RequestMapping(value = "/updataUserInfo")
    public @ResponseBody JsonResult updataUserInfo(@RequestParam(value = "username") String username,
                                                   @RequestParam(value = "phone") String phone) {
        JsonResult jsonResult = new JsonResult();
        User user = new User();
        user.setUsername(username);
        user.setPhone(phone);
        try {
            if (userService.updataUserInfo(user)) jsonResult.setSuccessful();
            else jsonResult.setFailure();
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            jsonResult.setFailure();
        }
        return jsonResult;
    }

    @PostMapping(value = "/uploadFile")
    public @ResponseBody JsonResult uploadFile(@RequestParam(value = "file") MultipartFile file) {
        JsonResult jsonResult = new JsonResult();
        try {
            if (file.isEmpty()) {
                jsonResult.setFailure("file is null");
                return jsonResult;
            }

            String fileName = file.getOriginalFilename();
            logger.info(fileName);

            String suffixName = fileName.substring(fileName.lastIndexOf('.'));
            logger.info(suffixName);

            String filePath = "/Users/jianzhang/IdeaProjects/UploadFile/";
            String path = filePath + fileName;

            File fileManager = new File(path);
            if (!fileManager.getParentFile().exists()) {
                fileManager.getParentFile().mkdirs();
            }
            file.transferTo(fileManager);
            jsonResult.setSuccessful();
        }
        catch (IllegalStateException e) {
            logger.error(e.getMessage(), e);
            jsonResult.setFailure();
        }
        catch (IOException e) {
            logger.error(e.getMessage(), e);
            jsonResult.setFailure();
        }
        return jsonResult;
    }

}
