package com.baidu.traveleverywhere.bean;

import java.util.List;

public class HomeInfomation {


    /**
     * code : 0
     * desc :
     * result : {"carousel":["http://cdn.banmi.com/banmiapp/rahdna/1521770663571_a5bf05381132e3ffe8add4821f1cba07.jpg"],"route":{"id":201,"banmiID":60,"cityID":50,"priceInCents":190,"title":"电影中的台湾","intro":"跟着镜头寻找宝岛小确幸","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521770663571_a5bf05381132e3ffe8add4821f1cba07.jpg","videoURL":"","sequence":-879,"description":"你好，我是千帆远澋，一个环球旅行家，也是台湾电影的爱好者。由于非常喜欢台湾电影的文艺怀旧，在之前旅居台湾的半年生活中，我跟随着镜头走遍了大大小小的地方，尤其是在大街小巷中闲逛，去探寻当地的人文风情，发现当地人最爱逛、最爱吃的各种小店。\n\n这一次我们先走进台湾的北部地区，一处历史与现代、喧闹与安宁相互交融却又非常和谐的地方。这里的每一座建筑，每一个转角，每一条街道，都有着属于自己的悠久历史。特别是当它们还被赋予了一段段虔诚的电影情节：《一页台北》里，女孩与男孩在诚品书店里不期而遇；《不能说的秘密》里，周杰伦在淡江中学，为桂纶镁弹奏一曲悠扬的钢琴旋律；《那些年，我们一起追的女孩》中，柯景腾和沈佳宜在平溪石底桥放飞表白的孔明灯......我看到了一个更加多情、更加温暖的台湾。\n \n我想带你来一场台湾的电影之旅，从\u201c悲情城市\u201d里的九份走起，沿着平溪铁路线一路向西，走过台北、北投、淡水，品味侯孝贤、杨德昌、钮承泽等等大导演对台湾各地的深度解读，好好体验一下老台北的百味生活。跟着镜头去寻找散落在这里的各种小确幸，你肯定会发现一个不一样的台湾。","shareTitle":"电影中的台湾","shareContent":"跟着镜头体验台湾文艺小资生活","purchasedTimes":1135,"price":"1.9","isPurchased":false,"isCollected":false,"city":"台北","shareURL":"http://banmi.com/app2017/route3.html?id=201","shareImageWechat":"http://cdn.banmi.com/banmiapp/rahdna/1521770663571_a5bf05381132e3ffe8add4821f1cba07.jpg"},"banmi":{"id":60,"name":"千帆远澋","location":"北京","occupation":"新华社签约摄影师、旅游自媒体大V","introduction":"你好，我是千帆远澋，环球旅行爱好者，新华社签约摄影师，旅游自媒体大V，曾旅居台湾半年。\n\u201c爱旅行，爱摄影，爱分享\u201d是我的生活理念。现如今，我一边旅行，一边生活，以一颗谦卑包容的心游走世界，目前已旅行整整10年，共走过100个国家的 480个城市，最远登陆南极大陆。\n读万卷书行万里路，有耀自他我得其助。愿有生之年，能与你分享旅行，平安喜乐。","photo4":"http://cdn.banmi.com/banmiapp/rahdna/1521783233759_b1734f9c8e1b2921347aaa610dcb0287.jpg","photo":"http://cdn.banmi.com/banmiapp/rahdna/1521783233759_b1734f9c8e1b2921347aaa610dcb0287.jpg"},"reviews":[{"reviewID":2867,"userName":"米霍","userPhoto":"http://media.banmi.com/photos/1451972644954_f2244faa58ff272163b209c32e552c8d","content":"阿妹茶楼的建筑真的很像千与千寻的景，九份逛起来很舒服，喜欢这种感觉~","createdAt":"2月前","images":[]},{"reviewID":2863,"userName":"阿丘","userPhoto":"http://media.banmi.com/photos/1452060410557_7bbf644b08a4f05150b6eaca54ab09ec","content":"还有没有台湾其他主题的攻略？环岛游什么的","createdAt":"2月前","images":[]},{"reviewID":2848,"userName":"李子围","userPhoto":"http://media.banmi.com/photos/1452649766181_d50fece9b8279b7bb96ba4ca4c0a30d7","content":"看完诚品的介绍来的，又种草了好几个地方，看来今年有必要把台湾安排上了，耶！","createdAt":"2月前","images":[]}],"reviewsCount":33}
     */

    private int code;
    private String desc;
    private ResultBean result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * carousel : ["http://cdn.banmi.com/banmiapp/rahdna/1521770663571_a5bf05381132e3ffe8add4821f1cba07.jpg"]
         * route : {"id":201,"banmiID":60,"cityID":50,"priceInCents":190,"title":"电影中的台湾","intro":"跟着镜头寻找宝岛小确幸","cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521770663571_a5bf05381132e3ffe8add4821f1cba07.jpg","videoURL":"","sequence":-879,"description":"你好，我是千帆远澋，一个环球旅行家，也是台湾电影的爱好者。由于非常喜欢台湾电影的文艺怀旧，在之前旅居台湾的半年生活中，我跟随着镜头走遍了大大小小的地方，尤其是在大街小巷中闲逛，去探寻当地的人文风情，发现当地人最爱逛、最爱吃的各种小店。\n\n这一次我们先走进台湾的北部地区，一处历史与现代、喧闹与安宁相互交融却又非常和谐的地方。这里的每一座建筑，每一个转角，每一条街道，都有着属于自己的悠久历史。特别是当它们还被赋予了一段段虔诚的电影情节：《一页台北》里，女孩与男孩在诚品书店里不期而遇；《不能说的秘密》里，周杰伦在淡江中学，为桂纶镁弹奏一曲悠扬的钢琴旋律；《那些年，我们一起追的女孩》中，柯景腾和沈佳宜在平溪石底桥放飞表白的孔明灯......我看到了一个更加多情、更加温暖的台湾。\n \n我想带你来一场台湾的电影之旅，从\u201c悲情城市\u201d里的九份走起，沿着平溪铁路线一路向西，走过台北、北投、淡水，品味侯孝贤、杨德昌、钮承泽等等大导演对台湾各地的深度解读，好好体验一下老台北的百味生活。跟着镜头去寻找散落在这里的各种小确幸，你肯定会发现一个不一样的台湾。","shareTitle":"电影中的台湾","shareContent":"跟着镜头体验台湾文艺小资生活","purchasedTimes":1135,"price":"1.9","isPurchased":false,"isCollected":false,"city":"台北","shareURL":"http://banmi.com/app2017/route3.html?id=201","shareImageWechat":"http://cdn.banmi.com/banmiapp/rahdna/1521770663571_a5bf05381132e3ffe8add4821f1cba07.jpg"}
         * banmi : {"id":60,"name":"千帆远澋","location":"北京","occupation":"新华社签约摄影师、旅游自媒体大V","introduction":"你好，我是千帆远澋，环球旅行爱好者，新华社签约摄影师，旅游自媒体大V，曾旅居台湾半年。\n\u201c爱旅行，爱摄影，爱分享\u201d是我的生活理念。现如今，我一边旅行，一边生活，以一颗谦卑包容的心游走世界，目前已旅行整整10年，共走过100个国家的 480个城市，最远登陆南极大陆。\n读万卷书行万里路，有耀自他我得其助。愿有生之年，能与你分享旅行，平安喜乐。","photo4":"http://cdn.banmi.com/banmiapp/rahdna/1521783233759_b1734f9c8e1b2921347aaa610dcb0287.jpg","photo":"http://cdn.banmi.com/banmiapp/rahdna/1521783233759_b1734f9c8e1b2921347aaa610dcb0287.jpg"}
         * reviews : [{"reviewID":2867,"userName":"米霍","userPhoto":"http://media.banmi.com/photos/1451972644954_f2244faa58ff272163b209c32e552c8d","content":"阿妹茶楼的建筑真的很像千与千寻的景，九份逛起来很舒服，喜欢这种感觉~","createdAt":"2月前","images":[]},{"reviewID":2863,"userName":"阿丘","userPhoto":"http://media.banmi.com/photos/1452060410557_7bbf644b08a4f05150b6eaca54ab09ec","content":"还有没有台湾其他主题的攻略？环岛游什么的","createdAt":"2月前","images":[]},{"reviewID":2848,"userName":"李子围","userPhoto":"http://media.banmi.com/photos/1452649766181_d50fece9b8279b7bb96ba4ca4c0a30d7","content":"看完诚品的介绍来的，又种草了好几个地方，看来今年有必要把台湾安排上了，耶！","createdAt":"2月前","images":[]}]
         * reviewsCount : 33
         */

        private RouteBean route;
        private BanmiBean banmi;
        private int reviewsCount;
        private List<String> carousel;
        private List<ReviewsBean> reviews;

        public RouteBean getRoute() {
            return route;
        }

        public void setRoute(RouteBean route) {
            this.route = route;
        }

        public BanmiBean getBanmi() {
            return banmi;
        }

        public void setBanmi(BanmiBean banmi) {
            this.banmi = banmi;
        }

        public int getReviewsCount() {
            return reviewsCount;
        }

        public void setReviewsCount(int reviewsCount) {
            this.reviewsCount = reviewsCount;
        }

        public List<String> getCarousel() {
            return carousel;
        }

        public void setCarousel(List<String> carousel) {
            this.carousel = carousel;
        }

        public List<ReviewsBean> getReviews() {
            return reviews;
        }

        public void setReviews(List<ReviewsBean> reviews) {
            this.reviews = reviews;
        }

        public static class RouteBean {
            /**
             * id : 201
             * banmiID : 60
             * cityID : 50
             * priceInCents : 190
             * title : 电影中的台湾
             * intro : 跟着镜头寻找宝岛小确幸
             * cardURL : http://cdn.banmi.com/banmiapp/rahdna/1521770663571_a5bf05381132e3ffe8add4821f1cba07.jpg
             * videoURL :
             * sequence : -879
             * description : 你好，我是千帆远澋，一个环球旅行家，也是台湾电影的爱好者。由于非常喜欢台湾电影的文艺怀旧，在之前旅居台湾的半年生活中，我跟随着镜头走遍了大大小小的地方，尤其是在大街小巷中闲逛，去探寻当地的人文风情，发现当地人最爱逛、最爱吃的各种小店。

             这一次我们先走进台湾的北部地区，一处历史与现代、喧闹与安宁相互交融却又非常和谐的地方。这里的每一座建筑，每一个转角，每一条街道，都有着属于自己的悠久历史。特别是当它们还被赋予了一段段虔诚的电影情节：《一页台北》里，女孩与男孩在诚品书店里不期而遇；《不能说的秘密》里，周杰伦在淡江中学，为桂纶镁弹奏一曲悠扬的钢琴旋律；《那些年，我们一起追的女孩》中，柯景腾和沈佳宜在平溪石底桥放飞表白的孔明灯......我看到了一个更加多情、更加温暖的台湾。
              
             我想带你来一场台湾的电影之旅，从“悲情城市”里的九份走起，沿着平溪铁路线一路向西，走过台北、北投、淡水，品味侯孝贤、杨德昌、钮承泽等等大导演对台湾各地的深度解读，好好体验一下老台北的百味生活。跟着镜头去寻找散落在这里的各种小确幸，你肯定会发现一个不一样的台湾。
             * shareTitle : 电影中的台湾
             * shareContent : 跟着镜头体验台湾文艺小资生活
             * purchasedTimes : 1135
             * price : 1.9
             * isPurchased : false
             * isCollected : false
             * city : 台北
             * shareURL : http://banmi.com/app2017/route3.html?id=201
             * shareImageWechat : http://cdn.banmi.com/banmiapp/rahdna/1521770663571_a5bf05381132e3ffe8add4821f1cba07.jpg
             */

            private int id;
            private int banmiID;
            private int cityID;
            private int priceInCents;
            private String title;
            private String intro;
            private String cardURL;
            private String videoURL;
            private int sequence;
            private String description;
            private String shareTitle;
            private String shareContent;
            private int purchasedTimes;
            private String price;
            private boolean isPurchased;
            private boolean isCollected;
            private String city;
            private String shareURL;
            private String shareImageWechat;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getBanmiID() {
                return banmiID;
            }

            public void setBanmiID(int banmiID) {
                this.banmiID = banmiID;
            }

            public int getCityID() {
                return cityID;
            }

            public void setCityID(int cityID) {
                this.cityID = cityID;
            }

            public int getPriceInCents() {
                return priceInCents;
            }

            public void setPriceInCents(int priceInCents) {
                this.priceInCents = priceInCents;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getCardURL() {
                return cardURL;
            }

            public void setCardURL(String cardURL) {
                this.cardURL = cardURL;
            }

            public String getVideoURL() {
                return videoURL;
            }

            public void setVideoURL(String videoURL) {
                this.videoURL = videoURL;
            }

            public int getSequence() {
                return sequence;
            }

            public void setSequence(int sequence) {
                this.sequence = sequence;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getShareTitle() {
                return shareTitle;
            }

            public void setShareTitle(String shareTitle) {
                this.shareTitle = shareTitle;
            }

            public String getShareContent() {
                return shareContent;
            }

            public void setShareContent(String shareContent) {
                this.shareContent = shareContent;
            }

            public int getPurchasedTimes() {
                return purchasedTimes;
            }

            public void setPurchasedTimes(int purchasedTimes) {
                this.purchasedTimes = purchasedTimes;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public boolean isIsPurchased() {
                return isPurchased;
            }

            public void setIsPurchased(boolean isPurchased) {
                this.isPurchased = isPurchased;
            }

            public boolean isIsCollected() {
                return isCollected;
            }

            public void setIsCollected(boolean isCollected) {
                this.isCollected = isCollected;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getShareURL() {
                return shareURL;
            }

            public void setShareURL(String shareURL) {
                this.shareURL = shareURL;
            }

            public String getShareImageWechat() {
                return shareImageWechat;
            }

            public void setShareImageWechat(String shareImageWechat) {
                this.shareImageWechat = shareImageWechat;
            }
        }

        public static class BanmiBean {
            /**
             * id : 60
             * name : 千帆远澋
             * location : 北京
             * occupation : 新华社签约摄影师、旅游自媒体大V
             * introduction : 你好，我是千帆远澋，环球旅行爱好者，新华社签约摄影师，旅游自媒体大V，曾旅居台湾半年。
             “爱旅行，爱摄影，爱分享”是我的生活理念。现如今，我一边旅行，一边生活，以一颗谦卑包容的心游走世界，目前已旅行整整10年，共走过100个国家的 480个城市，最远登陆南极大陆。
             读万卷书行万里路，有耀自他我得其助。愿有生之年，能与你分享旅行，平安喜乐。
             * photo4 : http://cdn.banmi.com/banmiapp/rahdna/1521783233759_b1734f9c8e1b2921347aaa610dcb0287.jpg
             * photo : http://cdn.banmi.com/banmiapp/rahdna/1521783233759_b1734f9c8e1b2921347aaa610dcb0287.jpg
             */

            private int id;
            private String name;
            private String location;
            private String occupation;
            private String introduction;
            private String photo4;
            private String photo;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getOccupation() {
                return occupation;
            }

            public void setOccupation(String occupation) {
                this.occupation = occupation;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public String getPhoto4() {
                return photo4;
            }

            public void setPhoto4(String photo4) {
                this.photo4 = photo4;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }

        public static class ReviewsBean {
            /**
             * reviewID : 2867
             * userName : 米霍
             * userPhoto : http://media.banmi.com/photos/1451972644954_f2244faa58ff272163b209c32e552c8d
             * content : 阿妹茶楼的建筑真的很像千与千寻的景，九份逛起来很舒服，喜欢这种感觉~
             * createdAt : 2月前
             * images : []
             */

            private int reviewID;
            private String userName;
            private String userPhoto;
            private String content;
            private String createdAt;
            private List<?> images;

            public int getReviewID() {
                return reviewID;
            }

            public void setReviewID(int reviewID) {
                this.reviewID = reviewID;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUserPhoto() {
                return userPhoto;
            }

            public void setUserPhoto(String userPhoto) {
                this.userPhoto = userPhoto;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public List<?> getImages() {
                return images;
            }

            public void setImages(List<?> images) {
                this.images = images;
            }
        }
    }
}
