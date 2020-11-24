
    //844. 比较含退格的字符串
//    给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后
//    ，判断二者是否相等，并返回结果。 # 代表退格字符。
//    注意：如果对空文本输入退格字符，文本继续为空。
    //输入：S = "ab#c", T = "ad#c"
    //输出：true
    //解释：S 和 T 都会变成 “ac”。
    //输入：S = "ab##", T = "c#d#"
    //输出：true
    //解释：S 和 T 都会变成 “”。
    //输入：S = "a##c", T = "#a#c"
    //输出：true
    //解释：S 和 T 都会变成 “c”。
    //输入：S = "a#c", T = "b"
    //输出：false
    //解释：S 会变成 “c”，但 T 仍然是 “b”。
//   a#bc##e
//   a#b#c##e

    //方法一
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        char[] chars1 = S.toCharArray();
        char[] chars2 = T.toCharArray();
        for (char ret1 : chars1) {
            if (ret1 == '#'&&!stack1.empty()) {
                stack1.pop();

            } else {
                stack1.push(ret1);
            }
        }
        for(int i=0;i<stack1.size();i++){
            if(stack1.get(i)=='#'){
                stack1.remove(i);
            }
        }
        for (char ret2 : chars2) {
            if (ret2 == '#'&&!stack2.empty()) {
                stack2.pop();
            }else {
                stack2.push(ret2);
            }
        }
        for(int i=0;i<stack2.size();i++){
            if(stack2.get(i)=='#'){
                stack2.remove(i);
            }
        }
        if(stack1.size()!=stack2.size()){
            return false;
        }
        int s1=stack1.size();
        int s2=stack2.size();
        while (!stack1.empty()&&!stack2.empty()){
            char a=stack1.pop();
            char b=stack2.pop();
            if(a!=b){
                return false;
            }
        }
        return true;
    }

