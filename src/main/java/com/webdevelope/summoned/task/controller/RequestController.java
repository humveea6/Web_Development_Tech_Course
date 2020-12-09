package com.webdevelope.summoned.task.controller;

import com.webdevelope.summoned.task.annotations.SeniorPermissionRequired;
import com.webdevelope.summoned.task.dto.PageDto;
import com.webdevelope.summoned.task.enums.SummonedTypeEnum;
import com.webdevelope.summoned.task.form.SummonedRequestForm;
import com.webdevelope.summoned.task.model.SummonedInfo;
import com.webdevelope.summoned.task.model.SummonedRequestInfo;
import com.webdevelope.summoned.task.service.SummonedRequestService;
import com.webdevelope.summoned.task.utils.WebResultUtil;
import com.webdevelope.summoned.task.vo.ResponseVo;
import com.webdevelope.summoned.task.vo.SummonedDetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author LingChen @HumveeA6
 * Created on 2020-10-17
 */
@RestController
@RequestMapping("/request")
@Slf4j
public class RequestController {

    @Autowired
    private SummonedRequestService summonedRequestService;

    @GetMapping("/list")
    ResponseEntity<String> getSummonedList(Long userId, Integer type, String search, PageDto pageDto){
        if(pageDto == null || pageDto.getPageSize() == null ||pageDto.getPageNum() ==null){
            return WebResultUtil.buildResult(ResponseVo.PARAM_ERROR("Page Params is null!"),HttpStatus.OK);
        }
        return WebResultUtil.buildResult(ResponseVo.success(
                summonedRequestService.getSummonedList(userId,type,search,pageDto)),HttpStatus.OK);
    }

    @GetMapping("/detail")
    ResponseEntity<String> getDetail(HttpServletResponse response,Long userId,Long summonedId){
        SummonedDetailVo summonedDetailVo = summonedRequestService.getSummonedDetail(userId, summonedId);

        return WebResultUtil.buildResult(ResponseVo.success(summonedDetailVo),HttpStatus.OK);
    }

    @GetMapping("/picture")
    ResponseEntity<String> getPicture(HttpServletResponse response,String path){
        getFile(response,path);

        return WebResultUtil.buildResult(ResponseVo.success(),HttpStatus.OK);
    }

    @PostMapping("/add")
    @SeniorPermissionRequired
    ResponseEntity<String> addOrUpdateSummoned(@RequestBody SummonedRequestForm form){

        int i = summonedRequestService.addOrUpdateRequest(form);
        if(i > 0){
            return WebResultUtil.buildResult(ResponseVo.success(),HttpStatus.OK);
        }
        return WebResultUtil.buildResult(ResponseVo.fail(),HttpStatus.OK);
    }

    @PostMapping("/file")
    @SeniorPermissionRequired
    ResponseEntity<String> uploadSummonedFile(MultipartFile file){
        if(file.isEmpty()){
            return WebResultUtil.buildResult(ResponseVo.PARAM_ERROR("文件为空！"),HttpStatus.OK);
        }
        String fileName = file.getOriginalFilename();
        String path = "/Users/humveea6/IdeaProjects/WebDevelopmentTechProject/src/main/resources/static/UploadFiles/";
//        String path = "/Users/jinnanhao/Desktop/shit/";
        File dest = new File(path + fileName);
        try {
            file.transferTo(dest);
            log.info("addSummoned 文件上传成功");
            return WebResultUtil.buildResult(ResponseVo.success(path+fileName), HttpStatus.OK);
        } catch (IOException e) {
            log.error("addSummoned file upload fail, "+e);
            return WebResultUtil.buildResult(ResponseVo.fail(), HttpStatus.OK);
        }
    }

    @GetMapping("/type")
    ResponseEntity<String> getSummonedType(){
//        List<Map<String, Object>> summonedTypeEnum = getAllEnumByClassName("com.webdevelope.summoned.task.enums.SummonedTypeEnum");
        List<Map<String, Object>> summonedTypeEnum = getAllEnumByMethod();

        return WebResultUtil.buildResult(ResponseVo.success(summonedTypeEnum),HttpStatus.OK);
    }

    /**
     * 根据枚举的字符串获取枚举的值
     *
     * @param className 包名+类名
     * @return
     * @throws Exception
     */
    public static List<Map<String, Object>> getAllEnumByClassName(String className) {
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            // 1.得到枚举类对象
            Class<Enum> clz = (Class<Enum>) Class.forName(className);
            // 2.得到所有枚举常量
            Object[] objects = clz.getEnumConstants();
            Method getCode = clz.getMethod("getCode");
            Method getMessage = clz.getMethod("getDesc");

            for (Object obj : objects) {
                Map<String, Object> map = new HashMap<>();
                map.put("code", getCode.invoke(obj));
                map.put("desc", getMessage.invoke(obj));
                list.add(map);
            }
            return list;
        }
        catch (Exception e){
            log.info("getAllEnumByClassName error: "+e);
            return list;
        }
    }

    public List<Map<String, Object>> getAllEnumByMethod(){
        List<Map<String, Object>> list = new ArrayList<>();
        List<SummonedTypeEnum> allEnums = SummonedTypeEnum.getAllEnums();
        for (SummonedTypeEnum Enum : allEnums) {
            Map<String, Object> map = new HashMap<>();
            map.put("code", Enum.getCode());
            map.put("desc", Enum.getDesc());
            list.add(map);
        }
        return list;
    }

    public void getFile(HttpServletResponse response, String path){
        FileInputStream fis = null;
        response.setContentType("image/png");
        try {
            OutputStream out = response.getOutputStream();
            File file = new File(path);
            fis = new FileInputStream(file);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            out.write(b);
            out.flush();
        } catch (Exception e) {
            log.error("getFile stream error: "+e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    log.error("getFile error: "+e);
                }
            }
        }
    }
}
