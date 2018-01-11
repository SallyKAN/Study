package TestDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v_kangjiayuan on 2018/1/11.
 */
public class replaceDemo {
    public static void main (String ars[]) {
        List<TwoTuple<String, String>> columnMap = new ArrayList<TwoTuple<String, String>>();
        TwoTuple<String, String> column1 =
                new TwoTuple<String, String>("buyTag","f.s_b");
        TwoTuple<String, String> column2 =
                new TwoTuple<String, String>("keyword","f.s_d");
        TwoTuple<String, String> column3 =
                new TwoTuple<String, String>("csm","f.c");
        TwoTuple<String, String> column4 =
                new TwoTuple<String, String>("csm63","f.k");
        TwoTuple<String, String> column5 =
                new TwoTuple<String, String>("csm31","f.l");
        columnMap.add(column1);
        columnMap.add(column2);
        columnMap.add(column3);
        columnMap.add(column4);
        columnMap.add(column5);
        String originConditions = "SELECT buyTag , keyword , csm , csm63 , csm31 FROM vsdp:tb_vsdp WHERE f.did = '10016'   AND buyTag = '2'  AND keyword = ''   AND  f.ver = 1515640614978 LIMIT 0,20";
        String originConditions1 = "";
        String originConditions2 = "";
        String originConditions3 = "";

        for (TwoTuple<String, String> tuple : columnMap) {
            originConditions1 = originConditions.replace(" " + tuple.first + " ", " " + tuple.second + " ");
        }
        for (TwoTuple<String, String> tuple : columnMap) {
            originConditions2 = originConditions.replaceAll(tuple.first, tuple.second );
        }
        for (TwoTuple<String, String> tuple : columnMap) {
            originConditions3 = originConditions.replaceFirst(tuple.first, tuple.second );
        }
        System.out.println(originConditions1);
        System.out.println(originConditions2);
        System.out.println(originConditions3);
    }
}
