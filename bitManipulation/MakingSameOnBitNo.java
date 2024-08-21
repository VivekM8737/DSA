public class MakingSameOnBitNo {
    public static long ncr(long n,int r){ 
        long din=1;
        long nur=1;
        if (n<r) {
            return 0;
        }
        long len=((n-r)>r?(n-r):r);
        long t=((n-r)<r?(n-r):r);
        for (long i = n; i > len; i--) {
            nur*=i;
            if(t>1){
                din*=t;
                t--;
            }
        }
        return nur/din;
    }
    public static int numSetbits(int x){
        int c=0;
        while (x>0) {
            int rmsb=x&(-x);
            x-=rmsb;
            c++;
            
        }
        return c;
    }
    public static long sameNoOfbits(long x, int nsb,int baseofnum){
        if (baseofnum<=0) {
            return 0;
        }
        long lb=(1L<<baseofnum);
        Long c=0L;
        if ((lb&x)==0) {
            c=sameNoOfbits(x, nsb, baseofnum-1);
        }
        else{
            c=ncr(baseofnum, nsb);
            c+=sameNoOfbits(x, nsb-1, baseofnum-1);

        }
        return c;

        

    }
    public static void main(String[] args) {
        int x=12;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(numSetbits(x));
        System.out.println(sameNoOfbits(x, numSetbits(x),Integer.toBinaryString(x).length()));
    }
}
