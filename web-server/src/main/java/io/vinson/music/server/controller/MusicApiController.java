package io.vinson.music.server.controller;

import io.vinson.music.server.dto.MusicInfoDto;
import io.vinson.music.server.service.MusicApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: jiangweixin
 * @date: 2020/5/14
 */

@Controller
@RequestMapping("/music-api")
public class MusicApiController {

    @Autowired
    protected MusicApiService musicApiService;

    @GetMapping("search-music")
    @ResponseBody
    public Map<String, Object> searchMusic(@RequestParam("keyword") String keyword) {

        Map<String, Object> jsonMap = new HashMap<>();

        List<MusicInfoDto> list = musicApiService.searchMusic(keyword, "migu");

        jsonMap.put("ret", 0);
        jsonMap.put("musicList", list);
        return jsonMap;
    }
}
