
class learn {
    static class Learn_for {
        int i;
        String str;

        public Learn_for(int i, String str) {
            this.str = str;
            this.i = i;

        }

        public void show() {
            System.out.println("The number: " + this.i + " " + this.str);
        }
    }

    public static void main(String[] args) {
        // learn l1=new learn();
        System.out.println("HI");
        Learn_for x1 = new Learn_for(5, "odd number");
        x1.show();
    }
}
