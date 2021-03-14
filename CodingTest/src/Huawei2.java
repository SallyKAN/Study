import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Huawei2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] sets = input.split(" ");
        int count = 1;
//        int latestEnd = Integer.MIN_VALUE;
//        int latestStart = Integer.MIN_VALUE;
        int earliestEnd = Integer.parseInt(sets[0].split(",")[1].replace("(", "").replace(")", ""));
        int earliestStart = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        TreeMap<Integer, Integer> res = new TreeMap<>();
        for (int i = 0; i < sets.length; i++) {
            String[] times = sets[i].split(",");
            int start = Integer.parseInt(times[0].replace("(", "").replace(")", ""));
            int end = Integer.parseInt(times[1].replace("(", "").replace(")", ""));
            map.put(end, start);
            if (end < earliestEnd) {
                earliestEnd = end;
                earliestStart = start;
            } else if (end == earliestEnd) {
                if (start > earliestStart) {
                    earliestStart = start;
                }
            }
        }
        //(3,6) (1,5) (6,7)
        int nextEnd = earliestEnd;

        res.put(earliestEnd, earliestStart);
        for (Integer end : map.keySet()) {
            int start = map.get(end);
            if (end >= nextEnd) {
                nextEnd = map.get(end);
                count++;
                res.put(end, map.get(end));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
            String time = "(" + entry.getValue() + "," + entry.getKey() + ")" + " ";
            sb.append(time);
        }
        System.out.println("count:" + count);
        System.out.println(sb.toString().trim());
    }
}
