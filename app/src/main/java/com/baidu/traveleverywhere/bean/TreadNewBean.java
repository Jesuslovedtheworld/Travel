package com.baidu.traveleverywhere.bean;

import java.util.List;

public class TreadNewBean {

    /**
     * id : 120
     * content : 大家还有什么好的科技路线推荐或者想看，我们攒一攒，把这个世界好好逛一逛。[haha]
     * audioURL :
     * audioLength : 0
     * images : []
     * firstImageWidth : 0
     * firstImageHeight : 0
     * likeCount : 7
     * replyCount : 6
     * isLiked : false
     * date : 2017-12-09 14:21
     */

    private int id;
    private String content;
    private String audioURL;
    private int audioLength;
    private int firstImageWidth;
    private int firstImageHeight;
    private int likeCount;
    private int replyCount;
    private boolean isLiked;
    private String date;
    private List<?> images;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAudioURL() {
        return audioURL;
    }

    public void setAudioURL(String audioURL) {
        this.audioURL = audioURL;
    }

    public int getAudioLength() {
        return audioLength;
    }

    public void setAudioLength(int audioLength) {
        this.audioLength = audioLength;
    }

    public int getFirstImageWidth() {
        return firstImageWidth;
    }

    public void setFirstImageWidth(int firstImageWidth) {
        this.firstImageWidth = firstImageWidth;
    }

    public int getFirstImageHeight() {
        return firstImageHeight;
    }

    public void setFirstImageHeight(int firstImageHeight) {
        this.firstImageHeight = firstImageHeight;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public boolean isIsLiked() {
        return isLiked;
    }

    public void setIsLiked(boolean isLiked) {
        this.isLiked = isLiked;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<?> getImages() {
        return images;
    }

    public void setImages(List<?> images) {
        this.images = images;
    }
}
