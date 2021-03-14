public class Generator<C> {
    static char[] chars = ("abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
    public static class Character extends Generator<java.lang.Character> {
        int index = -1;
        public java.lang.Character next(){
            index = (index + 1) % chars.length;
            return chars[index];
        }
    }

}
