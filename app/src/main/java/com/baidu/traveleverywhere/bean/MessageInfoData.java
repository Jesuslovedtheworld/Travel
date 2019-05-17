package com.baidu.traveleverywhere.bean;

public class MessageInfoData {
    private String info;
    private String time;
    private String inform;

    public MessageInfoData(String info, String time, String inform) {
        this.info = info;
        this.time = time;
        this.inform = inform;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInform() {
        return inform;
    }

    public void setInform(String inform) {
        this.inform = inform;
    }

    @Override
    public String toString() {
        return "MessageInfoData{" +
                "info='" + info + '\'' +
                ", time='" + time + '\'' +
                ", inform='" + inform + '\'' +
                '}';
    }
}
