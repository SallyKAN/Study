import java.util.Deque;
import java.util.LinkedList;

public class stringValue {

    public int getValue(String str){
        return value(str.toCharArray(), 0)[0];
    }

    public int[] value(char[] chars, int i){
        Deque<String> deq = new LinkedList<String>();
        int pre = 0;
        int[] bar = null;
        while (i < chars.length && chars[i] != ')'){
            if(chars[i] > '0' && chars[i] < '9'){
                pre = pre * 10 + chars[i++] - '0';
            } else if(chars[i] != '('){
                addNum(deq, pre);
                deq.addLast(String.valueOf(chars[i++]));
                pre = 0;
            } else {
                bar = value(chars, i+1);
                pre = bar[0];
                i = bar[1] + 1;
            }
        }
        addNum(deq, pre);
        return new int[]{getNum(deq),i};
    }

    public void addNum(Deque<String> deque, int num){
        if(!deque.isEmpty()){
            int cur = 0;
            String top = deque.pollLast();
            if(top.equals("+") || top.equals("-")){
                deque.addLast(top);
            } else {
                cur = Integer.valueOf(deque.pollLast());
                num = top.equals("*") ? (cur * num) : (cur / num);
            }
        }
        deque.addLast(String.valueOf(num));
    }

    public int getNum(Deque<String> deque){
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!deque.isEmpty()){
            cur = deque.pollFirst();
            if(cur.equals("+")){
                add= true;
            } else if(cur.equals("-")){
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String test = "3+2*4*(6+7)";
        stringValue value = new stringValue();
        System.out.println(value.getValue(test));
    }
}

