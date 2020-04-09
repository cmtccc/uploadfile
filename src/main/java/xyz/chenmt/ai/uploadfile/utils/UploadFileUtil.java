package xyz.chenmt.ai.uploadfile.utils;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @program byh-service-patient
 * @description: 文件上传工具类
 * @author: chenmet
 * @create: 2019/03/06 15:56
 */
public class UploadFileUtil {


    public static List<String> upload(List<CommonsMultipartFile> files) {
        List<String> urls = new ArrayList<>();
        String newPath="/ossFile/";
        for (CommonsMultipartFile file : files) {
            try {
                if (null != file) {
                    String filename = file.getOriginalFilename();
                    if (!"".equals(filename.trim())) {
                        String name=System.currentTimeMillis()+filename.substring(filename.lastIndexOf("."));
                        File newFile = new File(newPath+name);
                        FileOutputStream os = new FileOutputStream(newFile);
                        os.write(file.getBytes());
                        os.close();
                        file.transferTo(newFile);
                        urls.add("http://47.105.52.207:8500/"+name);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return urls;
    }

}
