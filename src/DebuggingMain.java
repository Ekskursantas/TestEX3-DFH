public class DebuggingMain {

    public static void main(String[] args){

        MyArrayListWithBugs a = new MyArrayListWithBugs();

        a.add(new RandomObject());
        a.add(new RandomObject());
        a.add(new RandomObject());
        a.add(new RandomObject());
        a.add(new RandomObject());
        a.add(new RandomObject());
        a.add(new RandomObject());
        a.add(new RandomObject());
        a.remove(5);
        RandomObject r = new RandomObject();
        System.out.println(r.Randomint);
        a.add(2, r);

        RandomObject o3 = (RandomObject)a.get(3);

        a.add(3, r);

        a.add(new RandomObject());



    }

}
