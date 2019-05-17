package com.baidu.traveleverywhere.bean;


import java.util.List;

public class HomeCollectionDaoBean {

    /**
     * code : 0
     * desc : 处理成功
     * result : {"page":1,"limit":20,"count":10,"collectedRoutes":[{"id":196,"cityID":52,"title":"濑户内海艺术双岛","intro":"直岛·丰岛美术馆巡礼","priceInCents":190,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521428871050_dc075f14d81fa0a814913d743bfbadf1.jpg","isPurchased":false,"createdAt":"2019-05-10","price":"1.90"},{"id":201,"cityID":50,"title":"电影中的台湾","intro":"跟着镜头寻找宝岛小确幸","priceInCents":190,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521770663571_a5bf05381132e3ffe8add4821f1cba07.jpg","isPurchased":false,"createdAt":"2019-05-09","price":"1.90"},{"id":195,"cityID":2,"title":"日本关西樱花祭","intro":"大阪·京都赏樱之旅","priceInCents":190,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1518095305572_09b354668a11b25b45c3975501e8b288.jpg","isPurchased":false,"createdAt":"2019-05-10","price":"1.90"},{"id":198,"cityID":51,"title":"环西澳自驾","intro":"沿印度洋海岸线探索奇澳之旅","priceInCents":190,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521105648687_4d84cb8e74f4dc80a9282bef22cd3c57.jpg","isPurchased":false,"createdAt":"2019-05-10","price":"1.90"},{"id":197,"cityID":2,"title":"胖死在大阪","intro":"攻克关西美食激战区","priceInCents":190,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521015627753_9f45790b0877cb985a126bef842f662a.jpg","isPurchased":false,"createdAt":"2019-05-10","price":"1.90"},{"id":194,"cityID":44,"title":"北疆（乌市&伊犁）","intro":"舌尖与心间的诱惑之旅","priceInCents":190,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1519637730133_b1d206d0280b64db2c2671dc4a6981b3.jpg","isPurchased":false,"createdAt":"2019-05-10","price":"1.90"},{"id":193,"cityID":43,"title":"天津美食","intro":"你不知道的美食王国","priceInCents":190,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1518177363940_29d250a6a42d880d4b0a0387d73f5df4.jpg","isPurchased":false,"createdAt":"2019-05-10","price":"1.90"},{"id":4,"cityID":1,"title":"浅草+晴空塔","intro":"6小时教你浅草寺的小众玩法","priceInCents":190,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510562390619_6e34b73004cf4a62e9ff248d3d0feb5e.jpg","isPurchased":false,"createdAt":"2019-05-10","price":"1.90"},{"id":59,"cityID":1,"title":"代官山+惠比寿","intro":"7小时逛遍东京最有格调的街区","priceInCents":190,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510714737875_72ef506ed467adff92766b5b0c24344c.jpg","isPurchased":false,"createdAt":"2019-05-10","price":"1.90"},{"id":60,"cityID":16,"title":"宇治","intro":"7小时品味古都的抹茶香","priceInCents":190,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510745071419_c9a5e6407b40686967f239a9393cfadf.jpg","isPurchased":false,"createdAt":"2019-05-09","price":"1.90"}]}
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
         * count : 10
         * collectedRoutes : [{"id":196,"cityID":52,"title":"濑户内海艺术双岛","intro":"直岛·丰岛美术馆巡礼","priceInCents":190,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521428871050_dc075f14d81fa0a814913d743bfbadf1.jpg","isPurchased":false,"createdAt":"2019-05-10","price":"1.90"},{"id":201,"cityID":50,"title":"电影中的台湾","intro":"跟着镜头寻找宝岛小确幸","priceInCents":190,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521770663571_a5bf05381132e3ffe8add4821f1cba07.jpg","isPurchased":false,"createdAt":"2019-05-09","price":"1.90"},{"id":195,"cityID":2,"title":"日本关西樱花祭","intro":"大阪·京都赏樱之旅","priceInCents":190,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1518095305572_09b354668a11b25b45c3975501e8b288.jpg","isPurchased":false,"createdAt":"2019-05-10","price":"1.90"},{"id":198,"cityID":51,"title":"环西澳自驾","intro":"沿印度洋海岸线探索奇澳之旅","priceInCents":190,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521105648687_4d84cb8e74f4dc80a9282bef22cd3c57.jpg","isPurchased":false,"createdAt":"2019-05-10","price":"1.90"},{"id":197,"cityID":2,"title":"胖死在大阪","intro":"攻克关西美食激战区","priceInCents":190,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1521015627753_9f45790b0877cb985a126bef842f662a.jpg","isPurchased":false,"createdAt":"2019-05-10","price":"1.90"},{"id":194,"cityID":44,"title":"北疆（乌市&伊犁）","intro":"舌尖与心间的诱惑之旅","priceInCents":190,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1519637730133_b1d206d0280b64db2c2671dc4a6981b3.jpg","isPurchased":false,"createdAt":"2019-05-10","price":"1.90"},{"id":193,"cityID":43,"title":"天津美食","intro":"你不知道的美食王国","priceInCents":190,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1518177363940_29d250a6a42d880d4b0a0387d73f5df4.jpg","isPurchased":false,"createdAt":"2019-05-10","price":"1.90"},{"id":4,"cityID":1,"title":"浅草+晴空塔","intro":"6小时教你浅草寺的小众玩法","priceInCents":190,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510562390619_6e34b73004cf4a62e9ff248d3d0feb5e.jpg","isPurchased":false,"createdAt":"2019-05-10","price":"1.90"},{"id":59,"cityID":1,"title":"代官山+惠比寿","intro":"7小时逛遍东京最有格调的街区","priceInCents":190,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510714737875_72ef506ed467adff92766b5b0c24344c.jpg","isPurchased":false,"createdAt":"2019-05-10","price":"1.90"},{"id":60,"cityID":16,"title":"宇治","intro":"7小时品味古都的抹茶香","priceInCents":190,"cardURL":"http://cdn.banmi.com/banmiapp/rahdna/1510745071419_c9a5e6407b40686967f239a9393cfadf.jpg","isPurchased":false,"createdAt":"2019-05-09","price":"1.90"}]
         */

        private int page;
        private int limit;
        private int count;
        private List<CollectedRoutesBean> collectedRoutes;

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

        public List<CollectedRoutesBean> getCollectedRoutes() {
            return collectedRoutes;
        }

        public void setCollectedRoutes(List<CollectedRoutesBean> collectedRoutes) {
            this.collectedRoutes = collectedRoutes;
        }

        public static class CollectedRoutesBean {
            /**
             * id : 196
             * cityID : 52
             * title : 濑户内海艺术双岛
             * intro : 直岛·丰岛美术馆巡礼
             * priceInCents : 190
             * cardURL : http://cdn.banmi.com/banmiapp/rahdna/1521428871050_dc075f14d81fa0a814913d743bfbadf1.jpg
             * isPurchased : false
             * createdAt : 2019-05-10
             * price : 1.90
             */

            private int id;
            private int cityID;
            private String title;
            private String intro;
            private int priceInCents;
            private String cardURL;
            private boolean isPurchased;
            private String createdAt;
            private String price;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getCityID() {
                return cityID;
            }

            public void setCityID(int cityID) {
                this.cityID = cityID;
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

            public int getPriceInCents() {
                return priceInCents;
            }

            public void setPriceInCents(int priceInCents) {
                this.priceInCents = priceInCents;
            }

            public String getCardURL() {
                return cardURL;
            }

            public void setCardURL(String cardURL) {
                this.cardURL = cardURL;
            }

            public boolean isIsPurchased() {
                return isPurchased;
            }

            public void setIsPurchased(boolean isPurchased) {
                this.isPurchased = isPurchased;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }
        }
    }
}
