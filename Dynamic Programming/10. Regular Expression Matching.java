class Solution {
    public boolean isMatch(String s, String p) {
        s = " " + s;
        p = " " + p;
        int sl = s.length(), pl = p.length();
        boolean f[][] = new boolean [sl][pl];
        char[] ss = s.toCharArray(), pp = p.toCharArray();;
        f[0][0] = true;
        for(int j=1; j<pl; j++){
            if(pp[j]=='*')
                f[0][j] = f[0][j-2];
            else
                f[0][j] = false;
        }
        for(int i = 1; i < sl; i++){
            f[i][0] = false;
        }
        for(int i = 1; i<sl; i++){
            for(int j = 1; j < pl; j++){
                if(pp[j] != '*'){
                    f[i][j] = f[i-1][j-1]&&(ss[i]==pp[j]||pp[j]=='.');
                }
                else 
                    f[i][j] = f[i][j-2]||(f[i-1][j] && (pp[j-1]==ss[i]|| pp[j-1]=='.'));
            }
        }
        return f[sl-1][pl-1];
    }
}
