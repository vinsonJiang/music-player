package io.vinson.music.api.main;

import io.vinson.music.api.domain.MusicInfo;
import io.vinson.music.api.platform.KugouPlatform;
import io.vinson.music.api.platform.MiguPlatform;
import io.vinson.music.api.platform.NeteasePlatform;
import io.vinson.music.api.util.FileDownloadUtil;

import java.util.List;

/**
 * @author: jiangweixin
 * @date: 2020/5/7
 */
public class Main {

    public static void main(String[] args) {
//        NeteasePlatform platform = new NeteasePlatform();
//        platform.search("少年");

//        KugouPlatform kugou = new KugouPlatform();
//        kugou.search("蝴蝶泉边");
//        kugou.url("04e4c1d0afb9deef3b0834aa1f71b654");
//        kugou.url("66958e19dbcf0c86a803bab5106fad90");
//        FileDownloadUtil.download("http://fs.ios.kugou.com/202005081752/bfcfc05d974b6ef2fd56f92d4777f757/G176/M01/00/05/8A0DAF2Sp82ALKGBAEGLnl7aohA609.mp3", "F:\\OtherProject\\Java\\workspace\\music-player\\web\\music.mp3");

        MiguPlatform migu = new MiguPlatform();
        List<MusicInfo> list = migu.search("词不达意");
        if(!list.isEmpty()) {
            MusicInfo music = list.get(0);
            FileDownloadUtil.download(music.getAddr(), "F:\\OtherProject\\Java\\workspace\\music-player\\web\\" + music.getName() + ".mp3");
        }
    }
}
