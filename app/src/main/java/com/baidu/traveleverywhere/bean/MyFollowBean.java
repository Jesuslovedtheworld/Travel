package com.baidu.traveleverywhere.bean;

import java.util.List;

public class MyFollowBean {

    /**
     * code : 0
     * desc :
     * result : {"page":1,"limit":20,"count":3,"banmi":[{"id":28,"name":"李炜","location":"北京","occupation":"蜻蜓FM名嘴，知名文化记者","introduction":"你好，我是李炜，知名文化记者。闲来无事最喜欢与两三好友对坐闲侃，聊聊历史八卦、文化趣事。我向来讲求有枣没枣儿，先打三杆子，搂草打兔子，咱们讲哪算哪儿。我不是专家，不谈之乎者也洋洋洒洒。或沉土中千载，或睹世间沧桑穿朝越代，它们背后的故事远比宫斗精彩。浩渺的历史文化中，总有有趣的故事让人折服与感悟，拿出一点时间，我们一起去看世界之大。觉得有趣，图您一乐呵，万一不妥，请您多包涵。","following":4627,"photo":"http://cdn.banmi.com/banmiapp/rahdna/1513046399561_9d3b02cad0eddee4347c93f43b3e5a7a.jpg","isFollowed":true},{"id":25,"name":"王自如","location":"深圳","occupation":"中国电子产品测评第一人","introduction":"Hello你好，我是王自如。借着在日本转机的机会，我来到了东京\u2014\u2014这个全球非常重要的科技之都。我个人呢也没来过日本，所以此次顺道前来朝拜一下。两天的时间，我几乎逛遍了东京所有与高新科技相关的景点，的确大开眼界，这次也希望通过伴米旅行，将这段行程分享给大家。","following":1467,"photo":"http://cdn.banmi.com/banmiapp/rahdna/1511748843296_eb8d5337fa7223727eb35fae8b29416e.jpg","isFollowed":true},{"id":54,"name":"JoJo","location":"苏州","occupation":"全球深度游旅行玩家","introduction":"你好，我是旅行玩家JoJo。从高中开始就在澳洲西部的珀斯留学，大学转到了东部的墨尔本。在将近7年的澳洲学习生活中，每个周末只要有空，我就会和朋友去周边旅行。其中我最喜欢的就是在西澳自驾游，不仅景美，西澳人的朴实热情更是让我感觉亲切友好，内心温暖。所以假如你想要一个放松心情、放慢脚步的旅行，我一定会首先推荐你来西澳。\n\n直到现在，我对旅行的上瘾热度也一直未减，一年有将近一半的时间我都在世界各地深度旅行，目前已经流浪过十几个国家，除了澳洲，待得最久的地方就是韩国了。我跑遍了梨泰院、江南、圣水洞等等我喜欢的街区，掘地三尺，挖出了不少我喜欢的地方。尤其因为我喜欢住在当地人家里，和他们一起生活、交谈，这样可以让我最快速地体验到最地道的本地文化，发现最受当地人欢迎的地方。所以跟着我深度游，可以了解每座城市不一样的魅力哦。","following":1623,"photo":"http://cdn.banmi.com/banmiapp/rahdna/1528685149853_08b015235b67fad16076b88f5b0b09c6.jpg","isFollowed":true}]}
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
         * page : 1
         * limit : 20
         * count : 3
         * banmi : [{"id":28,"name":"李炜","location":"北京","occupation":"蜻蜓FM名嘴，知名文化记者","introduction":"你好，我是李炜，知名文化记者。闲来无事最喜欢与两三好友对坐闲侃，聊聊历史八卦、文化趣事。我向来讲求有枣没枣儿，先打三杆子，搂草打兔子，咱们讲哪算哪儿。我不是专家，不谈之乎者也洋洋洒洒。或沉土中千载，或睹世间沧桑穿朝越代，它们背后的故事远比宫斗精彩。浩渺的历史文化中，总有有趣的故事让人折服与感悟，拿出一点时间，我们一起去看世界之大。觉得有趣，图您一乐呵，万一不妥，请您多包涵。","following":4627,"photo":"http://cdn.banmi.com/banmiapp/rahdna/1513046399561_9d3b02cad0eddee4347c93f43b3e5a7a.jpg","isFollowed":true},{"id":25,"name":"王自如","location":"深圳","occupation":"中国电子产品测评第一人","introduction":"Hello你好，我是王自如。借着在日本转机的机会，我来到了东京\u2014\u2014这个全球非常重要的科技之都。我个人呢也没来过日本，所以此次顺道前来朝拜一下。两天的时间，我几乎逛遍了东京所有与高新科技相关的景点，的确大开眼界，这次也希望通过伴米旅行，将这段行程分享给大家。","following":1467,"photo":"http://cdn.banmi.com/banmiapp/rahdna/1511748843296_eb8d5337fa7223727eb35fae8b29416e.jpg","isFollowed":true},{"id":54,"name":"JoJo","location":"苏州","occupation":"全球深度游旅行玩家","introduction":"你好，我是旅行玩家JoJo。从高中开始就在澳洲西部的珀斯留学，大学转到了东部的墨尔本。在将近7年的澳洲学习生活中，每个周末只要有空，我就会和朋友去周边旅行。其中我最喜欢的就是在西澳自驾游，不仅景美，西澳人的朴实热情更是让我感觉亲切友好，内心温暖。所以假如你想要一个放松心情、放慢脚步的旅行，我一定会首先推荐你来西澳。\n\n直到现在，我对旅行的上瘾热度也一直未减，一年有将近一半的时间我都在世界各地深度旅行，目前已经流浪过十几个国家，除了澳洲，待得最久的地方就是韩国了。我跑遍了梨泰院、江南、圣水洞等等我喜欢的街区，掘地三尺，挖出了不少我喜欢的地方。尤其因为我喜欢住在当地人家里，和他们一起生活、交谈，这样可以让我最快速地体验到最地道的本地文化，发现最受当地人欢迎的地方。所以跟着我深度游，可以了解每座城市不一样的魅力哦。","following":1623,"photo":"http://cdn.banmi.com/banmiapp/rahdna/1528685149853_08b015235b67fad16076b88f5b0b09c6.jpg","isFollowed":true}]
         */

        private int page;
        private int limit;
        private int count;
        private List<BanmiBean> banmi;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<BanmiBean> getBanmi() {
            return banmi;
        }

        public void setBanmi(List<BanmiBean> banmi) {
            this.banmi = banmi;
        }

        public static class BanmiBean {
            /**
             * id : 28
             * name : 李炜
             * location : 北京
             * occupation : 蜻蜓FM名嘴，知名文化记者
             * introduction : 你好，我是李炜，知名文化记者。闲来无事最喜欢与两三好友对坐闲侃，聊聊历史八卦、文化趣事。我向来讲求有枣没枣儿，先打三杆子，搂草打兔子，咱们讲哪算哪儿。我不是专家，不谈之乎者也洋洋洒洒。或沉土中千载，或睹世间沧桑穿朝越代，它们背后的故事远比宫斗精彩。浩渺的历史文化中，总有有趣的故事让人折服与感悟，拿出一点时间，我们一起去看世界之大。觉得有趣，图您一乐呵，万一不妥，请您多包涵。
             * following : 4627
             * photo : http://cdn.banmi.com/banmiapp/rahdna/1513046399561_9d3b02cad0eddee4347c93f43b3e5a7a.jpg
             * isFollowed : true
             */

            private int id;
            private String name;
            private String location;
            private String occupation;
            private String introduction;
            private int following;
            private String photo;
            private boolean isFollowed;

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

            public int getFollowing() {
                return following;
            }

            public void setFollowing(int following) {
                this.following = following;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public boolean isIsFollowed() {
                return isFollowed;
            }

            public void setIsFollowed(boolean isFollowed) {
                this.isFollowed = isFollowed;
            }
        }
    }
}
