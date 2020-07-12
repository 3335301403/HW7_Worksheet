package cn.yu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Graph {
    public Map<String, List<String>> neighbours;

    public long switchLoop(List<String> init, BigDecimal q, boolean logFlag) {
        List<String> threshold = new ArrayList<String>();
        threshold.addAll(init);
        if (logFlag) System.out.println("t1:" + threshold.stream().sorted().collect(Collectors.joining(" ,")));
        int timeflag = 2;
        List<String> temp = new ArrayList<String>();
        temp.add("-1");
        while (temp.size() > 0) {
            temp.clear();
            Set<Map.Entry<String, List<String>>> entrySet = neighbours.entrySet();
            for (Map.Entry<String, List<String>> e : entrySet) {
                String key = e.getKey();
                List<String> value = e.getValue();
                if (!threshold.contains(key)) {
                    Long q1 = value.stream().filter(n -> threshold.contains(n)).count();
                    BigDecimal temp_q1 = new BigDecimal(q1);
                    BigDecimal temp_q2 = q.multiply(new BigDecimal(value.size()));
//                    System.out.println(key + ":" + temp_q1 + "," + temp_q2);
                    double f1 = temp_q1.setScale(8, BigDecimal.ROUND_HALF_UP).doubleValue();
                    double f2 = temp_q2.setScale(8, BigDecimal.ROUND_HALF_UP).doubleValue();
                    if (Math.abs(f1-f2)<=0.000000001 || f1 > f2) {
                        temp.add(key);
                    }
                }
            }
            if (logFlag)
                System.out.println("t" + timeflag + ":" + temp.stream().map(n -> Integer.parseInt(n)).sorted().map(n -> n + "").collect(Collectors.joining(" ,")));
            threshold.addAll(temp);
            timeflag++;
        }

        long left = neighbours.keySet().stream().filter(n -> !threshold.contains(n)).count();
        return left;
    }

    public double findMaxP(List<String> init) {
        double result_e = 1.0;
        double result_b = 0.0;

        while (Math.abs(result_e - result_b) > 0.000001) {
            double result_mid = (result_e + result_b) / 2;
//            System.out.println(result_mid);
            long mid = this.switchLoop(init, new BigDecimal(result_mid), false);

            if (mid == 0) {
                result_b = result_mid;
            } else {
                result_e = result_mid;
            }
        }
        return result_b;
    }
}
