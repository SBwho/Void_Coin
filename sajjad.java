class sajjad{
    public static void main(String[] args) {
        System.out.println("this is sajjad Branch");
        transaction sajjadTransaction= new transaction("sajjad", "pinky", 10);
        String s= sajjadTransaction.calculateHash();
        System.out.println("hash code is : "+ s);
    }
}
