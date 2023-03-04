class Twitter {

    private static final int maxSize = 10;

    private final Map<Integer, Tweets> userTweets = new HashMap<>();
    private final Map<Integer, Followees> userFollowees = new HashMap<>();
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, Timer.getTimestamp());
        userTweets.computeIfAbsent(userId, id -> new Tweets(maxSize)).add(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Followees followees = userFollowees.get(userId);
        Set<Integer> users = new HashSet<>();
        users.add(userId);
        if (followees != null && followees.size() != 0) {
            for (int followeeId : followees) {
                users.add(followeeId);
            }
        }

        Queue<Tweet> heap = new PriorityQueue<>((a, b) -> a.timestamp - b.timestamp);
        for (int user : users) {
            Tweets tweets = userTweets.get(user);
            if (tweets == null) {
                continue;
            }

            for (Tweet tweet : tweets) {
                heap.offer(tweet);
                
                if (heap.size() > maxSize) {
                    heap.poll();
                }
            }
        }

        LinkedList<Integer> result = new LinkedList<>();
        while (!heap.isEmpty()) {
            result.addFirst(heap.poll().id);
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        userFollowees.computeIfAbsent(followerId, x -> new Followees()).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (userFollowees.containsKey(followerId)) {
            userFollowees.get(followerId).unfollow(followeeId);
        }
    }

    private static class Followees implements Iterable<Integer> {
        private final Set<Integer> followees = new HashSet<>();

        void follow(int followee) {
            followees.add(followee);
        }

        void unfollow(int followee) {
            followees.remove(followee);
        }

        int size() {
            return followees.size();
        }

        @Override
        public Iterator<Integer> iterator() {
            return followees.iterator();
        }
    }

    private static class Tweets implements Iterable<Tweet> {
        private final int maxSize;
        private final LinkedList<Tweet> tweets;

        Tweets(int maxSize) {
            this.maxSize = maxSize;
            this.tweets = new LinkedList<>();
        }

        void add(Tweet tweet) {
            tweets.addFirst(tweet);

            if (tweets.size() > maxSize) {
                tweets.removeLast();
            }
        }

        int size() {
            return tweets.size();
        }

        @Override
        public Iterator<Tweet> iterator() {
            return tweets.iterator();
        }
    }

    private static class Tweet {
        final int id;
        final int timestamp;

        Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    private static class Timer {
        private static int time = 0;

        static int getTimestamp() {
            return time++;
        }
    }
}