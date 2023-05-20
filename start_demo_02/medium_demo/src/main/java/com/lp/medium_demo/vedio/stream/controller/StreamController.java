package com.lp.medium_demo.vedio.stream.controller;

import com.lp.medium_demo.vedio.stream.handler.NonStaticResourceHttpRequestHandler;
import lombok.AllArgsConstructor;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author lipeng
 * @Date 2023/4/17 8:43
 * @Version 1.0
 */
@RestController
@RequestMapping("/file")
@AllArgsConstructor
public class StreamController {

    private final NonStaticResourceHttpRequestHandler nonStaticResourceHttpRequestHandler;

    @GetMapping("/video")
    public void videoPreview(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //假如我把视频1.mp4放在了static下的video文件夹里面
        //sourcePath 是获取resources文件夹的绝对地址
        //realPath 即是视频所在的磁盘地址
        String sourcePath = ClassUtils.getDefaultClassLoader().getResource("").getPath().substring(1);
        String realPath = sourcePath +"static/video/1.mp4";


        Path filePath = Paths.get(realPath );
        if (Files.exists(filePath)) {
            // 探测当前文件的类型
            String mimeType = Files.probeContentType(filePath);
            if (!StringUtils.isEmpty(mimeType)) {
                response.setContentType(mimeType);
            }
            request.setAttribute(NonStaticResourceHttpRequestHandler.ATTR_FILE, filePath);
            nonStaticResourceHttpRequestHandler.handleRequest(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        }
    }



}
