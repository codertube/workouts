class TinyUrlDemo {

    String convertIdToShortUrl(int id) {
        char[] allowedChars = 'abcdefghiklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789'.toCharArray();
        StringBuffer shortUrl = new StringBuffer();
         while(id != 0) {
             id =id % 62;
             shortUrl.append(allowedChars[id]);
             id = id / 62;
         }
        return shortUrl.toString();
    }

    int convertShortUrlToId(String shortUrl) {
        int id = 0;
        for(int i = 0; i < shortUrl.length(); i++) {

            if(shortUrl.charAt(i) >= 'a' && shortUrl.charAt(i) <= 'z') {
                id = id * 62 + shortUrl.charAt(i);
            }
            if(shortUrl.charAt(i) >= 'A' && shortUrl.charAt(i) <= 'Z') {
                id = id * 62 + shortUrl.charAt(i) + 26;
            }
            if(shortUrl.charAt(i) >= '0' && shortUrl.charAt(i) <= '9') {
                id = id * 62 + shortUrl.charAt(i) + 52;
            }
        }

        return id;
    }

    public static void main(String[] args) {
        Map<Integer, String> idUrlMap = new HashMap<Integer, String>();
        Random randomInt  = new Random();
        idUrlMap.put(randomInt, "https://www.revolut.com/rewards-personalised-cashback-and-discounts/");

    }
}