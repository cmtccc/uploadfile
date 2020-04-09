package xyz.chenmt.ai.uploadfile.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import xyz.chenmt.ai.uploadfile.utils.UploadFileUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program uploadfile
 * @description: 文件上传接口
 * @author: chenmet
 * @create: 2019/06/04 15:32
 */
@RestController
public class UploadController {


    @RequestMapping("/upload")
    public Map<String,Object> upload(@RequestParam(value = "file",required = false) List<CommonsMultipartFile> file){
        Map<String,Object> map = new HashMap<>();
        List<String> list= UploadFileUtil.upload(file);
        map.put("data",list);
        map.put("code",200);
        map.put("msg","上传成功");
        return map;
    }


}
