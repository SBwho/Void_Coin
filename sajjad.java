class sajjad {
    public static void main(String[] args) {
        transaction sajjadTransaction= new transaction("sajjad", "piunky", 10);
       String s= sajjadTransaction.calculateHash();
       System.out.println("hash code is: " + s);
    }
}
