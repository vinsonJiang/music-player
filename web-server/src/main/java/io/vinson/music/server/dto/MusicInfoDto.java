package io.vinson.music.server.dto;

import java.util.List;

/**
 * @author: jiangweixin
 * @date: 2020/5/14
 */
public class MusicInfoDto {

    private String id;

    private String name;

    private List<String> artist;

    private String album;

    private String picId;

    private String lyricId;

    private String source;

    public String getId() {
        return id;
    }

    public MusicInfoDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MusicInfoDto setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getArtist() {
        return artist;
    }

    public MusicInfoDto setArtist(List<String> artist) {
        this.artist = artist;
        return this;
    }

    public String getAlbum() {
        return album;
    }

    public MusicInfoDto setAlbum(String album) {
        this.album = album;
        return this;
    }

    public String getPicId() {
        return picId;
    }

    public MusicInfoDto setPicId(String picId) {
        this.picId = picId;
        return this;
    }

    public String getLyricId() {
        return lyricId;
    }

    public MusicInfoDto setLyricId(String lyricId) {
        this.lyricId = lyricId;
        return this;
    }

    public String getSource() {
        return source;
    }

    public MusicInfoDto setSource(String source) {
        this.source = source;
        return this;
    }
}
