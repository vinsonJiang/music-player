package io.vinson.music.server.service;

import io.vinson.music.api.domain.MusicInfo;
import io.vinson.music.api.platform.MiguPlatform;
import io.vinson.music.server.dto.MusicInfoDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jiangweixin
 * @date: 2020/5/14
 */

@Service
public class MusicApiService {

    public List<MusicInfoDto> searchMusic(String keyword, String source) {
        MiguPlatform migu = new MiguPlatform();
        List<MusicInfo> list = migu.search(keyword);

        List<MusicInfoDto> result = new ArrayList<>();
        for(MusicInfo musicInfo : list) {
            result.add(parseMusicInfo(musicInfo));
        }
        return result;
    }


    private MusicInfoDto parseMusicInfo(MusicInfo musicInfo) {
        MusicInfoDto dto = new MusicInfoDto();

        dto.setId(musicInfo.getId()).setName(musicInfo.getName());
        dto.setAlbum(musicInfo.getAlbum());
        dto.setArtist(musicInfo.getArtist());
        dto.setLyricId(musicInfo.getLyricId());
        dto.setPicId(musicInfo.getPicId());
        dto.setSource(musicInfo.getSource());
        return dto;
    }

}
