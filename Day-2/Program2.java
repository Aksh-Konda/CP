import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int start[] = new int[n];
        int end[] = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = scn.nextInt();
            end[i] = scn.nextInt();
        }

        System.out.println(minCourts(start, end));

        scn.close();
    }

    static int minCourts(int start[], int end[]) {
        Arrays.sort(start);
        Arrays.sort(end);

        int court = 0;
        int k = 0;
        for (int i = 0; i < start.length; i++) {
            if (start[i] < end[k])
                court++;
            else
                k++;
        }

        return court;
    }

    static int minCourtsReq(Game games[]) {
        if (games.length <= 1)
            return games.length;

        List<List<Game>> courts = new ArrayList<>();

        for (Game game : games) {
            List<Game> court = getSuitableCourt(game, courts);
            if (court == null) {
                court = new ArrayList<>();
                court.add(game);
                courts.add(court);
            } else {
                court.add(game);
            }
        }

        return courts.size();
    }

    static List<Game> getSuitableCourt(Game game, List<List<Game>> courts) {
        for (List<Game> court : courts) {
            boolean overlapping = false;
            for (Game curr : court) {
                if (!(curr.end <= game.start || curr.start >= game.end)) {
                    overlapping = true;
                    break;
                }
            }
            if (!overlapping) {
                return court;
            }
        }

        return null;
    }

    static class Game {
        int start;
        int end;

        Game(int s, int e) {
            start = s;
            end = e;
        }
    }
}
