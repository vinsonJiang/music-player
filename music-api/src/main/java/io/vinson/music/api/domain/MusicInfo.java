package io.vinson.music.api.domain;

import java.util.List;

/**
 * @author: jiangweixin
 * @date: 2020/5/8
 */
public class MusicInfo {

    private String id;

    private String name;

    private List<String> artist;

    private String album;

    private String urlId;

    private String picId;

    private String lyricId;

    private String source;

    public String getId() {
        return id;
    }

    public MusicInfo setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MusicInfo setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getArtist() {
        return artist;
    }

    public MusicInfo setArtist(List<String> artist) {
        this.artist = artist;
        return this;
    }

    public String getAlbum() {
        return album;
    }

    public MusicInfo setAlbum(String album) {
        this.album = album;
        return this;
    }

    public String getUrlId() {
        return urlId;
    }

    public MusicInfo setUrlId(String urlId) {
        this.urlId = urlId;
        return this;
    }

    public String getPicId() {
        return picId;
    }

    public MusicInfo setPicId(String picId) {
        this.picId = picId;
        return this;
    }

    public String getLyricId() {
        return lyricId;
    }

    public MusicInfo setLyricId(String lyricId) {
        this.lyricId = lyricId;
        return this;
    }

    public String getSource() {
        return source;
    }

    public MusicInfo setSource(String source) {
        this.source = source;
        return this;
    }

    @Override
    public String toString() {
        return "MusicInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", artist=" + artist +
                ", album='" + album + '\'' +
                ", urlId='" + urlId + '\'' +
                ", picId='" + picId + '\'' +
                ", lyricId='" + lyricId + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
