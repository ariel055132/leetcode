import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Design a Leaderboard class, which has 3 functions:
 * 1. addScore(playerId, score): Update the leaderboard by adding score to the given player's score. If there is no player with such id in the leaderboard, add him to the leaderboard with the given score.
 * 2. top(K): Return the score sum of the top K players.
 * 3. reset(playerId): Reset the score of the player with the given id to 0 (in other words erase it from the leaderboard). It is guaranteed that the player was added to the leaderboard before calling this function.
 *
 * Input:
 * Operation: ["Leaderboard","addScore","addScore","addScore","addScore","addScore","top","reset","reset","addScore","top"]
 * Operation: [[],[1,73],[2,56],[3,39],[4,51],[5,4],[1],[1],[2],[2,51],[3]]
 * Output: [null,null,null,null,null,null,73,null,null,null,141]
 */

public class Q1244 {
    // Map for saving the player's score
    // Key: playerId, Value: player score
    HashMap<Integer, Integer> map;

    // Map for saving the
    // Key: Score, Value: Number of player that having the score
    // For finding the top K more quickly
    TreeMap<Integer, Integer> scoreMap;

    public Q1244() {
        map = new HashMap<>();
        scoreMap = new TreeMap<>(Collections.reverseOrder());
    }

    public void addScore(int playerId, int score) {
        // If the map does not contain playerId, just append it to map
        if (!map.containsKey(playerId)) {
            map.put(playerId, score);
            scoreMap.put(score, scoreMap.getOrDefault(score, 0) + 1);
        } else {
            // If the map contains the playerId value, Update the leaderboard by adding score to the given player's score.
            // First, finding the currentScore of that playerId.
            int currentScore = map.get(playerId);
            // scoreMap operation (the number of players with the currentScore should decrease by 1 for the score update)
            scoreMap.put(currentScore, scoreMap.get(currentScore) - 1);
            // If the number of players of the currentScore is 0 after decrease, remove it
            if (scoreMap.get(currentScore) == 0) {
                scoreMap.remove(currentScore);
            }
            // Score addition
            int newScore = currentScore + score;
            map.put(playerId, newScore);
            scoreMap.put(newScore, scoreMap.getOrDefault(newScore, 0) +1);
        }
    }

    public int top(int K) {
        int sum = 0;
        int cnt = 0;
        for (int key : scoreMap.keySet()) {
            int freq = scoreMap.get(key);
            for (int i = 0; i < freq; i++) {
                sum += key;
                cnt++;
                if (cnt == K) {
                    return sum;
                }
            }
        }
        return sum;
    }

    public void reset(int playerId) {
        // Null check
        if (!map.containsKey(playerId)) {
            return; // Player does not exist, just return
        }
        int currentScore = map.get(playerId);
        // scoreMap operation (the number of players with the currentScore should decrease by 1 for the score reset)
        scoreMap.put(currentScore, scoreMap.get(currentScore) - 1);
        // If the number of players of the currentScore is 0 after decrease, remove it
        if (scoreMap.get(currentScore) == 0) {
            scoreMap.remove(currentScore);
        }
        // Remove the playerId
        map.remove(playerId);
    }
}
