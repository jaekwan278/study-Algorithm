package programmers.hash.bestAlbum;

// 베스트 엘범

import utils.Compare;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BestAlbum {

    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> totalPlays = new HashMap<>();
        Map<String, List<Integer>> genreSongs = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
            genreSongs.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(i);
        }

        List<String> orderedGenres = new ArrayList<>(totalPlays.keySet());
        orderedGenres.sort((g1, g2) -> totalPlays.get(g2) - totalPlays.get(g1));

        List<Integer> answer = new ArrayList<>();

        for(String genre : orderedGenres){

            List<Integer> songs = genreSongs.get(genre);
            songs.sort((s1, s2) -> {
                if(plays[s2] == plays[s1]) return s1 - s2;
                else return plays[s2] - plays[s1];
            });

            int limit = Math.min(2, songs.size());
            for(int i = 0; i < limit; i++){
                answer.add(songs.get(i));
            }

        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution2(String[] genres, int[] plays) {

        Map<String, Integer> totalPlays = IntStream.range(0, plays.length)
                .boxed()
                .collect(Collectors.groupingBy(i -> genres[i], Collectors.summingInt(i -> plays[i])));

        return totalPlays.keySet().stream()
                .sorted((g1, g2) -> totalPlays.get(g2) - totalPlays.get(g1))
                .flatMap(g -> IntStream.range(0, plays.length)
                        .filter(i -> genres[i].equals(g))
                        .boxed()
                        .sorted((s1, s2) -> plays[s2] != plays[s1] ? plays[s2] - plays[s1] : s1 - s2)
                        .limit(2)
                ).mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        BestAlbum task = new BestAlbum();

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(task.solution2(genres, plays)));

        Compare.measureTime(()-> task.solution(genres, plays), ()-> task.solution2(genres, plays));
    }

}
