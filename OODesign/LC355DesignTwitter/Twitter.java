package OODesign.LC355DesignTwitter;

import java.util.*;

class Twitter {
    public HashMap<Integer, HashSet<Integer>> followerMap;
    public HashMap<Integer,HashSet<Integer>> followingMap;
    public HashMap<Integer, ArrayList<int[]>> postMap;
    public int timestamp;
    public Twitter() {
        followerMap = new HashMap<>();
        followingMap = new HashMap<>();
        postMap = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if(!postMap.containsKey(userId))   postMap.put(userId,new ArrayList<int[]>());
        postMap.get(userId).add(new int[]{tweetId,timestamp});
        timestamp++;
    }

    public List<Integer> getNewsFeed(int userId) {
        //own posts and his following users' posts
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b)->(a[1]-b[1]));//min heap
        for(int[] post:postMap.getOrDefault(userId,new ArrayList<int[]>())){
            if(heap.size()<10)  heap.offer(post);
            else if(post[1]<heap.peek()[1])    continue;
            else{
                heap.poll();
                heap.offer(post);
            }
        }
        for(int followingUserId:followingMap.getOrDefault(userId,new HashSet<Integer>())){
            for(int[] post:postMap.getOrDefault(followingUserId,new ArrayList<int[]>())){
                if(heap.size()<10)  heap.offer(post);
                else if(post[1]<heap.peek()[1])    continue;
                else{
                    heap.poll();
                    heap.offer(post);
                }
            }
        }
        List<Integer> feed = new LinkedList<>();
        while(!heap.isEmpty()){
            feed.add(0,heap.poll()[0]);
            if(feed.size()>=10) break;
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if(!followerMap.containsKey(followeeId))    followerMap.put(followeeId,new HashSet<Integer>());
        followerMap.get(followeeId).add(followerId);
        if(!followingMap.containsKey(followerId))   followingMap.put(followerId,new HashSet<Integer>());
        followingMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(followerMap.containsKey(followeeId))     followerMap.get(followeeId).remove(followerId);
        if(followingMap.containsKey(followerId))    followingMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
